package holinko.com;

import holinko.com.dao.CarDAO;
import holinko.com.dao.CarDAOImpl;
import holinko.com.dao.MechanicDAO;
import holinko.com.dao.MechanicDAOImpl;
import holinko.com.model.Car;
import holinko.com.model.Mechanic;
import holinko.com.model.ServiceStation;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel
 */
public class Main
{
    private static CarDAO carDAO = new CarDAOImpl();

    public static void main(String[] args)
    {
        try
        {
            //get all cars +
//            List<Car> cars = carDAO.getAllCars();
//            for (int i = 0; i < cars.size(); i++) {
//                System.out.println(cars.get(i));
//            }

            //get car by id +
            Car car = carDAO.getCarById(497L);
            System.out.println(car);
//            Set<ServiceStation> stations = car.getServiceStationSet();
//            System.out.println(stations);
//            for (ServiceStation s: stations)
//            {
//                System.out.println(s.getCarSet());
//            }

            //add car +
//            Car car = new Car("Honda", "Honda Clarity", 20, new BigDecimal(30000), "2010");
//            ServiceStation gogolStr = new ServiceStation("Гоголя 27");
//            car.getServiceStationSet().add(gogolStr);
//            carDAO.addCar(car);

            //update +
//            Car car = new Car("Honda", "Honda Clarity", 25, new BigDecimal(80000), "2016");
//            carDAO.updateCar(car, 495L);

            //delete +
//            Car car = new Car();
//            car.setId(498L);
//            carDAO.deleteCar(car);


        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
