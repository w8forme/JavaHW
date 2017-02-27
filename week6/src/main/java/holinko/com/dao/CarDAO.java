package holinko.com.dao;

import holinko.com.model.Car;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Pavel
 */
public interface CarDAO
{
    void addCar(Car car) throws SQLException;
    void updateCar(Car car) throws SQLException;
    void deleteCar(Car car) throws SQLException;
    Car getCarById(Long car_id) throws SQLException;
    Collection getAllCars() throws SQLException;
}
