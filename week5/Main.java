package week5;

import week5.utills.UserDao;

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
            ConnectionManager.init(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try (Connection conn = ConnectionManager.getConnection(url, login, pass))
        {
            UserDao database= new UserDao(conn);
            System.out.println(database.getCarById(25).toString());
            System.out.println(database.getEngineById(69).toString());
            Engine engine = database.getEngineById(32);
            cars = engine.getInstalledInCars();
            for (Car car :
                    cars)
            {
                System.out.println(car);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

    }
}
