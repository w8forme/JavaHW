package holinko.com.dao;

import holinko.com.model.Mechanic;
import holinko.com.model.ServiceStation;
import holinko.com.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pavel
 */
public class MechanicDAOImplTest
{
    Session session;
    MechanicDAO mechanicDAO = new MechanicDAOImpl();

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
    public void addMechanic() throws Exception
    {
        Mechanic mechanic = new Mechanic("Иван", "Петров");
        ServiceStation zheleznayaStr = new ServiceStation("Железная 13");
        mechanic.setServiceStation(zheleznayaStr);
        mechanicDAO.addMechanic(mechanic);
        Mechanic mechanicAfterAdd = mechanicDAO.getMechanicById(mechanic.getId());
        assertTrue(mechanic.getId() > 0);
        assertEquals(mechanicAfterAdd.getId(), mechanic.getId());
        assertEquals(mechanicAfterAdd.getName(), mechanic.getName());
        assertEquals(mechanicAfterAdd.getSurname(), mechanic.getSurname());
    }

    @Test
    public void updateMechanic() throws Exception
    {
        Mechanic mechanicForUpdate = new Mechanic("Дмитрий", "Иванов");
        mechanicDAO.updateMechanic(mechanicForUpdate, 1L);
        Mechanic mechanicAfterUpdate = mechanicDAO.getMechanicById(1L);
        assertEquals(mechanicAfterUpdate.getId(), mechanicForUpdate.getId());
        assertEquals(mechanicAfterUpdate.getName(), mechanicForUpdate.getName());
        assertEquals(mechanicAfterUpdate.getSurname(), mechanicForUpdate.getSurname());
    }

    @Test
    public void deleteMechanic() throws Exception
    {
        Mechanic mechanicForDelete = new Mechanic("Анатолий", "Жуков");
        mechanicDAO.addMechanic(mechanicForDelete);
        Long check = mechanicForDelete.getId();
        mechanicDAO.deleteMechanic(mechanicForDelete);
        assertNull(mechanicDAO.getMechanicById(check));
    }

    @Test
    public void getMechanicById() throws Exception
    {
        Mechanic mechanic = new Mechanic("Борис", "Васильев");
        mechanicDAO.addMechanic(mechanic);
        Long check = mechanic.getId();
        Mechanic mechanicAfterGet = mechanicDAO.getMechanicById(check);
        assertEquals(mechanicAfterGet.getId(), mechanic.getId());
        assertEquals(mechanicAfterGet.getName(), mechanic.getName());
        assertEquals(mechanicAfterGet.getSurname(), mechanic.getSurname());
    }

    @Test
    public void getAllMechanics() throws Exception
    {
        assertTrue(mechanicDAO.getAllMechanics().size() > 0);
    }

}