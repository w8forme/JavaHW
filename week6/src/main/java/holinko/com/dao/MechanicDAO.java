package holinko.com.dao;

import holinko.com.model.Mechanic;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pavel
 */
public interface MechanicDAO
{
    void addMechanic(Mechanic mechanic) throws SQLException;
    void updateMechanic(Mechanic mechanic, Long mechanic_id) throws SQLException;
    void deleteMechanic(Mechanic mechanic) throws SQLException;
    Mechanic getMechanicById(Long mechanic_id) throws SQLException;
    List<Mechanic> getAllMechanics() throws SQLException;
}
