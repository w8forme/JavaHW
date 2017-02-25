package week5;

import week5.utills.*;

import java.sql.*;
import java.util.Set;

/**
 * Created by Pavel
 */
public class Main
{

    public static void main(String[] args)
    {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/Cars_catalog";
        String login = "postgres";
        String pass = "postgres";
        Set<Car> cars;
        try
        {
            JdbcUtils.init(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try (Connection conn = JdbcUtils.getConnection(url, login, pass))
        {
            CarDao carDao= new CarDaoJdbc(conn);
            EngineDao engineDao = new EngineDaoJdbc(conn);
            Engine engine = new Engine(2100, 150);
            Car car = new Car(2016, "Audi", "Audi R8", 164000, 72);
            //carDao.insertCar(car);
            //engineDao.insertEngine(engine);
            System.out.println(carDao.getCarById(7272).toString());
            System.out.println(engineDao.getEngineById(299).toString());
//            cars = engineDao.getEngineById(72).getInstalledInCars();
//            for (Car car2: cars)
//            {
//                System.out.println(car2);
//            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }
}
