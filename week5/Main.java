package week5;

import java.sql.*;
import java.util.Set;

/**
 * Created by Pavel
 */
public class Main
{

    static Set<Car> cars;
    static Set<Engine> engines;

    private static int randomInt(int min, int max)
    {
        return (int) (Math.random() * (++max - min)) + min;
    }

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
            ConnectionToDatabase.init(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try (Connection conn = ConnectionToDatabase.getConnection(url, login, pass))
        {
            cars = rff.parsAndCreateCar();
            engines = rff.parsAndCreateEngine();
            int[] resultCar = fd.addCars(conn, cars);
            int[] resultEngine = fd.addEngines(conn, engines);


        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

    }
}
