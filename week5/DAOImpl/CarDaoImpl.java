package week5.DAOImpl;

import week5.DAO.CarDao;
import week5.Entities.Car;
import week5.Entities.Engine;
import week5.utills.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pavel
 */
public class CarDaoImpl implements CarDao
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

    public CarDaoImpl(Connection conn)
    {
        this.conn = conn;
    }

    private Car carBuilder(ResultSet rs) throws SQLException
    {

        Engine engine = new Engine();
        Car car = null;
        while (rs.next())
        {
            carId = rs.getInt("id");
            year = rs.getInt("year");
            make = rs.getString("make");
            model = rs.getString("model");
            price = rs.getDouble("price");
            engineId = rs.getInt("id_engine");
            displacement = rs.getDouble("displacement");
            power = rs.getDouble("power");
            engine.setId(engineId);
            engine.setDisplacement(displacement);
            engine.setPower(power);
            car = new Car(carId, year, make, model, price, engineId, engine);
        }
        return car;
    }

    @Override
    public Car getCarById(int id)
    {
        ResultSet rs = null;
        Car car = null;
        String sqlCar = "SELECT\n" +
                "  c.*,\n" +
                "  e.displacement,\n" +
                "  e.power\n" +
                "FROM car c\n" +
                "  JOIN engine e ON c.id_engine = e.id\n" +
                "WHERE c.id = ?;";

        try (PreparedStatement pst = conn.prepareStatement(sqlCar))
        {
            pst.setInt(1, id);
            rs = pst.executeQuery();
            car = carBuilder(rs);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            JdbcUtils.closeQuietly(rs);
        }
        return car;
    }
    @Override
    public void insertCar(Car car)
    {
        String sqlCar = "INSERT INTO car (year, make, model, price, id_engine) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement pst = conn.prepareStatement(sqlCar))
        {
            pst.setInt(1, car.getYear());
            pst.setString(2, car.getMake());
            pst.setString(3, car.getModel());
            pst.setDouble(4, car.getPrice());
            pst.setInt(5, car.getId_engine());
            pst.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
