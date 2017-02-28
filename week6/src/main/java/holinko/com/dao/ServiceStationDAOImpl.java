package holinko.com.dao;

import holinko.com.model.ServiceStation;
import holinko.com.utils.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
public class ServiceStationDAOImpl implements ServiceStationDAO
{
    @Override
    public void addServiceStation(ServiceStation serviceStation) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(serviceStation);
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
    public void updateServiceStation(ServiceStation serviceStation, Long serviceStation_id) throws SQLException
    {
        Session session = null;
        try
        {
            serviceStation.setId(serviceStation_id);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(serviceStation);
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
    public void deleteServiceStation(ServiceStation serviceStation) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(serviceStation);
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
    public ServiceStation getServiceStationById(Long serviceStation_id) throws SQLException
    {
        Session session = null;
        ServiceStation serviceStation = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            serviceStation = session.get(ServiceStation.class, serviceStation_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return serviceStation;
    }

    @Override
    public List<ServiceStation> getAllServiceStations() throws SQLException
    {
        Session session = null;
        List<ServiceStation> serviceStations = new ArrayList<ServiceStation>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            serviceStations = session.createCriteria(ServiceStation.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return serviceStations;
    }
}
