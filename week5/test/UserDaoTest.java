package week5.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import week5.utills.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        String sql = "SELECT * FROM car WHERE make = ? AND model = ? AND year = ? AND id_engine = ? AND price = ?;";
        int carId = -1;
        carDao.insertCar(car);
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "Audi");
        pst.setString(2, "Audi R8");
        pst.setInt(3, 2016);
        pst.setInt(4, 72);
        pst.setDouble(5, 164000);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            carId = rs.getInt("id");
        }
        Car testCar = carDao.getCarById(carId);
        assertEquals(car.getModel(), testCar.getModel());
        assertEquals(car.getMake(), testCar.getMake());
        assertEquals(car.getId_engine(), testCar.getId_engine());
        assertEquals(car.getYear(), testCar.getYear());
        assertEquals(car.getPrice(), testCar.getPrice(), 0.0);

    }

    @Test
    public void insertEngine() throws Exception
    {
        String sql = "SELECT * FROM engine WHERE displacement = ? AND power = ?;";
        int engineId = -1;
        engineDao.insertEngine(engine);
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setDouble(1, 2100);
        pst.setDouble(2, 150);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            engineId = rs.getInt("id");
        }
        Engine testEngine = engineDao.getEngineById(engineId);
        assertEquals(engine.getDisplacement(), testEngine.getDisplacement(), 0.0);
        assertEquals(engine.getPower(), testEngine.getPower(), 0.0);
    }

    @After
    public void tearDown() throws Exception
    {
        conn.close();
    }
}