package holinko.com.dao;

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
public class ServiceStationDAOImplTest
{
    Session session;
    ServiceStationDAO stationDAO = new ServiceStationDAOImpl();

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
    public void addServiceStation() throws Exception
    {
        ServiceStation serviceStation = new ServiceStation("Петровского 128");
        stationDAO.addServiceStation(serviceStation);
        ServiceStation serviceStationAfterAdd = stationDAO.getServiceStationById(serviceStation.getId());
        assertTrue(serviceStation.getId() > 0);
        assertEquals(serviceStationAfterAdd.getId(), serviceStation.getId());
        assertEquals(serviceStationAfterAdd.getAddress(), serviceStation.getAddress());
    }

    @Test
    public void updateServiceStation() throws Exception
    {
        ServiceStation ssForUpdate = new ServiceStation("Петровского 128");
        stationDAO.updateServiceStation(ssForUpdate, 5L);
        ServiceStation ssAfterUpdate = stationDAO.getServiceStationById(5L);
        assertEquals(ssAfterUpdate.getId(), ssForUpdate.getId());
        assertEquals(ssAfterUpdate.getAddress(), ssForUpdate.getAddress());
    }

    @Test
    public void deleteServiceStation() throws Exception
    {
        ServiceStation ssForDelete = new ServiceStation("Петровского 128");
        stationDAO.addServiceStation(ssForDelete);
        Long check = ssForDelete.getId();
        stationDAO.deleteServiceStation(ssForDelete);
        assertNull(stationDAO.getServiceStationById(check));
    }

    @Test
    public void getServiceStationById() throws Exception
    {
        ServiceStation serviceStation = new ServiceStation("Петровского 128");
        stationDAO.addServiceStation(serviceStation);
        Long check = serviceStation.getId();
        ServiceStation ssAfterGet = stationDAO.getServiceStationById(check);
        assertEquals(ssAfterGet.getAddress(), serviceStation.getAddress());
    }

    @Test
    public void getAllServiceStations() throws Exception
    {
        assertTrue(stationDAO.getAllServiceStations().size() > 0);
    }

}