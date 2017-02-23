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
public class Database implements UserInput
{
    private Connection conn;


    public Database(Connection conn)
    {
        this.conn = conn;
    }

    @Override
    public Car getCarById(int id)
    {
        int year;           //The year of production
        String make;        //Maker of the car
        String model;       //Model name
        double price;       //The price of the car
        Engine engine;      //Engine installed into the car
        int engineId;
        String sqlCar = "SELECT c.*, e.displacement, e.power FROM car c JOIN engine e ON WHERE id = ?;";
        ResultSet rs = null;
        Car car = null;
        try (PreparedStatement pst = conn.prepareStatement(sqlCar))
        {
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next())
            {
                year = rs.getInt("year");
                make = rs.getString("make");
                model = rs.getString("model");
                price = rs.getDouble("price");
                engineId = rs.getInt("id_engine");
                engine = getEngineById(engineId);
                car = new Car(id, year, make, model, price, engine);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public Engine getEngineById(int id)
    {
        double displacement;        //Displacement of specific engine (1000 - 3000 cc)
        double power;               //Engine power (60-280 hp)
        Set<Car> installedInCars = new HashSet<Car>();   //Set of cars that has the current engine
        Engine engine;
        Car car;
        String sqlEngine = "SELECT e.id AS engine_id, e.displacement, e.power, c.id AS car_id, c.model, c.price, c.make, c.year FROM engine e JOIN car c ON e.id = c.id_engine WHERE e.id = ?;";
        ResultSet rs = null;
        try (PreparedStatement pst = conn.prepareStatement(sqlEngine))
        {
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next())
            {
                displacement = rs.getDouble("displacement");
                power = rs.getDouble("power");

                    //Make logic for parse cars set into hashset
//                installedInCars.add(getCarById());
//                engine = new Engine();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null; //Change for engine
    }

    @Override
    public void insertCar(Car car)
    {

    }

    @Override
    public void insertEngine(Engine engine)
    {

    }
}
