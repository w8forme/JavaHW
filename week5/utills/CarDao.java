package week5.utills;

import java.sql.SQLException;

/**
 * Created by Pavel
 */
public interface CarDao
{
    Car getCarById(int id) throws SQLException;
    void insertCar(Car car) throws SQLException;
}
