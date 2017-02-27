package holinko.com.dao;

import holinko.com.model.Car;
import holinko.com.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
public class CarDAOImpl implements CarDAO
{
    @Override
    public void addCar(Car car) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
    }

    @Override
    public void updateCar(Car car) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(car);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
    }

    @Override
    public void deleteCar(Car car) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
    }

    @Override
    public Car getCarById(Long car_id) throws SQLException
    {
        Session session = null;
        Car car = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            car = session.get(Car.class, car_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() throws SQLException
    {
        Session session = null;
        List<Car> cars = new ArrayList<Car>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cars = session.createCriteria(Car.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cars;
    }
}
