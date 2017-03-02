package holinko.com.dao;

import holinko.com.model.Car;
import holinko.com.model.ServiceStation;
import holinko.com.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Pavel
 */
public class CarDAOImplTest
{
    Session session;
    CarDAO carDAO = new CarDAOImpl();

    @Before
    public void setUp() throws Exception
    {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @After
    public void tearDown() throws Exception
    {
        if (session != null && session.isOpen())
        {
            session.close();
        }
    }

    @Test
    public void addCar() throws Exception
    {
        Car car = new Car("Honda", "Honda Clarity", 20, new BigDecimal(30000), "2010");
        ServiceStation gogolStr = new ServiceStation("Гоголя 27");
        car.getServiceStationSet().add(gogolStr);
        carDAO.addCar(car);
        Car carAfterAdd = carDAO.getCarById(car.getId());
        assertTrue(car.getId() > 0);
        assertEquals(carAfterAdd.getId(), car.getId());
        assertEquals(carAfterAdd.getMake(), car.getMake());
        assertEquals(carAfterAdd.getModel(), car.getModel());
        assertEquals(carAfterAdd.getId_engine(), car.getId_engine());
        assertEquals(carAfterAdd.getDate(), car.getDate());
    }

    @Test
    public void updateCar() throws Exception
    {
        Car carForUpdate = new Car("Honda", "Honda Clarity", 25, new BigDecimal(80000), "2016");
        carDAO.updateCar(carForUpdate, 495L);
        Car carAfterUpdate = carDAO.getCarById(495L);
        assertEquals(carAfterUpdate.getId(), carForUpdate.getId());
        assertEquals(carAfterUpdate.getMake(), carForUpdate.getMake());
        assertEquals(carAfterUpdate.getModel(), carForUpdate.getModel());
        assertEquals(carAfterUpdate.getId_engine(), carForUpdate.getId_engine());
        assertEquals(carAfterUpdate.getDate(), carForUpdate.getDate());
    }

    @Test
    public void deleteCar() throws Exception
    {
        Car carForDelete = new Car("Honda", "Honda Clarity", 30, new BigDecimal(50000), "2008");
        carDAO.addCar(carForDelete);
        Long check = carForDelete.getId();
        carDAO.deleteCar(carForDelete);
        assertNull(carDAO.getCarById(check));
    }

    @Test
    public void getCarById() throws Exception
    {
        Car car = new Car("Honda", "Honda Clarity", 30, new BigDecimal(50000), "2008");
        carDAO.addCar(car);
        Long check = car.getId();
        Car carAfterGet = carDAO.getCarById(check);
        assertEquals(carAfterGet.getMake(), car.getMake());
        assertEquals(carAfterGet.getModel(), car.getModel());
        assertEquals(carAfterGet.getDate(), car.getDate());
        assertEquals(carAfterGet.getId_engine(), car.getId_engine());
    }

    @Test
    public void getAllCars() throws Exception
    {
        assertTrue(carDAO.getAllCars().size() > 0);
    }
}