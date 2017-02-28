package holinko.com.dao;

import holinko.com.model.Car;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel
 */
public interface CarDAO
{
    void addCar(Car car) throws SQLException;
    void updateCar(Car car, Long car_id) throws SQLException;
    void deleteCar(Car car) throws SQLException;
    Car getCarById(Long car_id) throws SQLException;
    List<Car> getAllCars() throws SQLException;
}
