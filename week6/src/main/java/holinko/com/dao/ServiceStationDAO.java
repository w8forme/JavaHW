package holinko.com.dao;

import holinko.com.model.ServiceStation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel
 */
public interface ServiceStationDAO
{
    void addServiceStation(ServiceStation serviceStation) throws SQLException;
    void updateServiceStation(ServiceStation serviceStation) throws SQLException;
    ServiceStation getServiceStationById(Long serviceStation_id) throws SQLException;
    List<ServiceStation> getAllServiceStations() throws SQLException;
}
