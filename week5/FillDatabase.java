package week5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Pavel
 */
public class FillDatabase
{
    public int[] addCars(Connection conn, Set<Car> cars)
    {
        String sqlCar = "INSERT INTO car (year, make, model, price, id_engine) VALUES (?, ?, ?, ?, ?);";
        int[] result = null;
        try (PreparedStatement pst = conn.prepareStatement(sqlCar))
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
            result = pst.executeBatch();
            conn.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public int[] addEngines(Connection conn, Set<Engine> engines)
    {
        String sqlEngine = "INSERT INTO engine (displacement, power) VALUES (?, ?);";
        int[] result = null;
        try (PreparedStatement pst = conn.prepareStatement(sqlEngine))
        {
            conn.setAutoCommit(false);
            for (Engine engine : engines)
            {
                pst.setDouble(1, engine.getDisplacement());
                pst.setDouble(2, engine.getPower());
                pst.addBatch();
            }
            result = pst.executeBatch();
            conn.commit();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
