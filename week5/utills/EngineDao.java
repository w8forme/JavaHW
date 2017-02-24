package week5.utills;

import java.sql.SQLException;

/**
 * Created by Pavel
 */
public interface EngineDao
{
    Engine getEngineById(int id) throws SQLException;
    void insertEngine(Engine engine) throws SQLException;
}
