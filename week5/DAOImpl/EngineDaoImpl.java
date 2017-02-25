package week5.DAOImpl;

import week5.DAO.EngineDao;
import week5.Entities.Car;
import week5.Entities.Engine;
import week5.utills.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
public class EngineDaoImpl implements EngineDao
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

    public EngineDaoImpl(Connection conn)
    {
        this.conn = conn;
    }

    private Engine buildEngine(ResultSet rs) throws SQLException
    {
        Engine engine = new Engine();
        rs.next();
        engineId = rs.getInt("id");
        displacement = rs.getDouble("displacement");
        power = rs.getDouble("power");
        engine.setId(engineId);
        engine.setDisplacement(displacement);
        engine.setPower(power);
        engine.setInstalledInCars(getSetCars(engineId, engine));
        return engine;
    }

    @Override
    public Engine getEngineById(int id)
    {
        ResultSet rs = null;
        Engine engine = null;
        String sqlEngine = "SELECT * FROM engine WHERE id = ?;";
        try (PreparedStatement pst = conn.prepareStatement(sqlEngine))
        {
            pst.setInt(1, id);
            rs = pst.executeQuery();
            engine = buildEngine(rs);
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
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

    private Set<Car> getSetCars(int id, Engine engine)
    {
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
        ResultSet rs = null;
        Set<Car> carSet = new LinkedHashSet<Car>();

        try ( PreparedStatement pst = conn.prepareStatement(sqlEngine))
        {
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next())
            {
                carId = rs.getInt("car_id");
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                price = rs.getDouble("price");
                carSet.add(new Car(carId, year, make, model, price, engineId, engine));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            JdbcUtils.closeQuietly(rs);
        }
        return carSet;
    }
}
