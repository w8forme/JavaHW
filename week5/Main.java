package week5;

import week5.utills.Database;

import java.sql.*;
import java.util.Set;

/**
 * Created by Pavel
 */
public class Main
{

    static Set<Car> cars;
    static Set<Engine> engines;

    public static void main(String[] args)
    {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/Cars_catalog";
        String login = "postgres";
        String pass = "postgres";
        //String sqlCar = "INSERT INTO car (year, make, model, price, id_engine) VALUES (1909, 'Ford', 'Model T', 100000, 1);";
        //String sqlEngine = "INSERT INTO engine (displacement, power) VALUES (1000, 60);";

        ReadFromFile rff = new ReadFromFile();
        FillDatabase fd = new FillDatabase();


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
            Database database= new Database(conn);


        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

    }
}
