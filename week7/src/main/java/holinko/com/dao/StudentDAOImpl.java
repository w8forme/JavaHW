package holinko.com.dao;

import holinko.com.model.Student;
import holinko.com.utils.HibernateUtil;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
public class StudentDAOImpl implements StudentDAO
{
    @Override
    public void addStudent(Student student)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
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
    public void updateStudent(Student student)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(student);
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
    public void deleteStudent(Long student_id)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            Student student = session.get(Student.class, student_id);
            session.beginTransaction();
            session.delete(student);
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
    public Student getStudentById(Long student_id)
    {
        Session session = null;
        Student student = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            student = session.get(Student.class, student_id);
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
        return student;
    }


    @Override
    public List<Student> getAllStudents()
    {
        Session session = null;
        List<Student> students = new ArrayList<Student>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
            Root<Student> from = criteria.from(Student.class);
            criteria.select(from);
            students = session.createQuery(criteria).getResultList();
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
        return students;
    }
}
