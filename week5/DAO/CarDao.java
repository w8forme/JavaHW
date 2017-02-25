package week5.DAO;

import week5.Entities.Car;

import java.sql.SQLException;

/**
 * Created by Pavel
 */
public interface CarDao
{
    Car getCarById(int id) throws SQLException;
    void insertCar(Car car) throws SQLException;
}
