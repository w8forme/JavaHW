package week5.DAO;

import week5.Entities.Engine;

import java.sql.SQLException;

/**
 * Created by Pavel
 */
public interface EngineDao
{
    Engine getEngineById(int id) throws SQLException;
    void insertEngine(Engine engine) throws SQLException;
}
