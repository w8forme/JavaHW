package holinko.com.dao;

import holinko.com.model.Car;
import holinko.com.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public void updateCar(Car car, Long car_id) throws SQLException
    {
        Session session = null;
        try
        {
            car.setId(car_id);
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
            System.err.println("Delete error!");
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
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            car = session.get(Car.class, car_id);
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
        return car;
    }

    @Override
    public List<Car> getAllCars() throws SQLException
    {
        Session session = null;
        List<Car> cars = new ArrayList<Car>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteria = builder.createQuery(Car.class);
            Root<Car> from = criteria.from(Car.class);
            criteria.select(from);
            cars = session.createQuery(criteria).getResultList();
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
        return cars;
    }
}
