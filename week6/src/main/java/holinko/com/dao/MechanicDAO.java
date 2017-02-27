package holinko.com.dao;

import holinko.com.model.Mechanic;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Pavel
 */
public interface MechanicDAO
{
    void addMechanic(Mechanic mechanic) throws SQLException;
    void updateMechanic(Mechanic mechanic) throws SQLException;
    Mechanic getMechanicById(Long mechanic_id) throws SQLException;
    Collection getAllMechanics() throws SQLException;
}
