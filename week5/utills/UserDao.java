package week5.utills;

import week5.Car;
import week5.Engine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
public class UserDao implements UserInput
{
    private Connection conn;

    int carId;
    int year;                   //The year of production
    String make;                //Maker of the car
    String model;               //Model name
    double price;               //The price of the car
    int engineId;               //Id of specify engine
    double displacement;        //Displacement of specific engine (1000 - 3000 cc)
    double power;               //Engine power (60-280 hp)


    public UserDao(Connection conn)
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
            car = new Car(carId, year, make, model, price, engine);
        }
        return car;
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
        return car;
    }

    @Override
    public Engine getEngineById(int id)
    {

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
        ResultSet rs;
        try (PreparedStatement pst = conn.prepareStatement(sqlEngine))
        {
            pst.setInt(1, id);
            rs = pst.executeQuery();
            engine = engineBuilder(rs);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return engine;
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
