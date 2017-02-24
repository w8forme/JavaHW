package week5.test;

import org.junit.Before;
import org.junit.Test;
import week5.utills.*;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

/**
 * Created by Pavel
 */
public class UserDaoTest
{
    Connection conn;
    CarDao carDao;
    EngineDao engineDao;
    Engine engine;
    Car car;

    @Before
    public void setUp() throws Exception
    {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/Cars_catalog";
        String login = "postgres";
        String pass = "postgres";
        Class.forName(driver);
        conn = DriverManager.getConnection(url, login, pass);
        carDao = new CarDaoJdbc(conn);
        engineDao = new EngineDaoJdbc(conn);
        engine = new Engine(2100, 150);
        car = new Car(2016, "Audi", "Audi R8", 164000, 72);
    }

    @Test
    public void testIfgetCarByIdNotNull() throws Exception
    {
        assertNotNull(carDao.getCarById(52));
    }

    @Test
    public void testIfgetEngineByIdNotNull() throws Exception
    {
        assertNotNull(engineDao.getEngineById(72));
    }

    @Test
    public void insertCar() throws Exception
    {
        carDao.insertCar(car);
        assertNotEquals(car, carDao.getCarById(20));
        assertNotNull(carDao.getCarById(20));

    }

    @Test
    public void insertEngine() throws Exception
    {

    }

}