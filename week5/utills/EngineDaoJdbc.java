package week5.utills;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
public class EngineDaoJdbc implements EngineDao
{
    private Connection conn;
    private int carId;
    private int year;                   //The year of production
    private String make;                //Maker of the car
    private String model;               //Model name
    private double price;               //The price of the car
    private int engineId;               //Id of specify engine
    private double displacement;        //Displacement of specific engine (1000 - 3000 cc)
    private double power;               //Engine power (60-280 hp)

    public EngineDaoJdbc(Connection conn)
    {
        this.conn = conn;
    }

    private Engine engineBuilder(ResultSet rs) throws SQLException
    {
        Set<Car> installedInCars = new HashSet<Car>();   //Set of cars that has the current engine
        Engine engine = new Engine();
        Car car = null;

        while (rs.next())
        {
            carId = rs.getInt("car_id");
            year = rs.getInt("year");
            make = rs.getString("make");
            model = rs.getString("model");
            price = rs.getDouble("price");
            engineId = rs.getInt("engine_id");
            displacement = rs.getDouble("displacement");
            power = rs.getDouble("power");
            engine.setId(engineId);
            engine.setDisplacement(displacement);
            engine.setPower(power);
            engine.setInstalledInCars(installedInCars);
            engine.getInstalledInCars().add(new Car(carId, year, make, model, price, engine));
        }
        return engine;
    }
    @Override
    public Engine getEngineById(int id)
    {
        ResultSet rs = null;
        Engine engine = null;
        String sqlEngine = "SELECT\n" +
                "  e.id AS engine_id,\n" +
                "  e.displacement,\n" +
                "  e.power,\n" +
                "  c.id AS car_id,\n" +
                "  c.model,\n" +
                "  c.price,\n" +
                "  c.make,\n" +
                "  c.year\n" +
                "FROM engine e\n" +
                "  JOIN car c ON e.id = c.id_engine\n" +
                "WHERE e.id = ?;";
        try (PreparedStatement pst = conn.prepareStatement(sqlEngine))
        {
            pst.setInt(1, id);
            rs = pst.executeQuery();
            engine = engineBuilder(rs);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JdbcUtils.closeQuietly(rs);
        }
        return engine;
    }
    @Override
    public void insertEngine(Engine engine)
    {
        String sqlEngine = "INSERT INTO engine (displacement, power) VALUES (?, ?);";
        try (PreparedStatement pst = conn.prepareStatement(sqlEngine))
        {
            pst.setDouble(1, engine.getDisplacement());
            pst.setDouble(2, engine.getPower());
            pst.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
