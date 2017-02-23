package week5;

import java.sql.*;
import java.util.Set;

/**
 * Created by Pavel
 */
public class Main
{

    static Set<Car> cars;

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
        String sqlCar = "INSERT INTO car (year, make, model, price, id_engine) VALUES (?, ?, ?, ?, ?);";
        String sqlEngine = "INSERT INTO engine (displacement, power) VALUES (?, ?);";

        ReadFromFile rff = new ReadFromFile();
        cars = rff.parsAndCreateCar();

        try
        {
            ConnectionToDatabase.init(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try (Connection conn = ConnectionToDatabase.getConnection(url, login, pass);
             PreparedStatement pst = conn.prepareStatement(sqlCar))
        {
            conn.setAutoCommit(false);
            for (Car car : cars)
            {
                pst.setInt(1, car.getYear());
                pst.setString(2, car.getMake());
                pst.setString(3, car.getModel());
                pst.setDouble(4, car.getPrice());
                pst.setInt(5, car.getId_engine());
                pst.addBatch();
            }
            int[] result = pst.executeBatch();
            conn.commit();

        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

    }
}
