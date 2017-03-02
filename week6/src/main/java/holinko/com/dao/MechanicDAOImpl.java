package holinko.com.dao;

import holinko.com.model.Mechanic;
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
public class MechanicDAOImpl implements MechanicDAO
{
    @Override
    public void addMechanic(Mechanic mechanic) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(mechanic);
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
    public void updateMechanic(Mechanic mechanic, Long mechanic_id) throws SQLException
    {
        Session session = null;
        try
        {
            mechanic.setId(mechanic_id);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(mechanic);
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
    public void deleteMechanic(Mechanic mechanic) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(mechanic);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (session != null && session.isOpen())
            {
                System.err.println("Delete error!");
                session.close();
            }
        }
    }

    @Override
    public Mechanic getMechanicById(Long mechanic_id) throws SQLException
    {
        Session session = null;
        Mechanic mechanic = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            mechanic = session.get(Mechanic.class, mechanic_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return mechanic;
    }

    @Override
    public List<Mechanic> getAllMechanics() throws SQLException
    {
        Session session = null;
        List<Mechanic> mechanics = new ArrayList<Mechanic>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Mechanic> criteria = builder.createQuery(Mechanic.class);
            Root<Mechanic> from = criteria.from(Mechanic.class);
            criteria.select(from);
            mechanics = session.createQuery(criteria).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return mechanics;
    }
}
