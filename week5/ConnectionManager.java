package week5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Pavel
 */
public class ConnectionManager
{

    public static void init(String driver) throws ClassNotFoundException
    {
        Class.forName(driver);
    }

    public static Connection getConnection(String url, String login, String pass) throws ClassNotFoundException, SQLException
    {
        return DriverManager.getConnection(url, login, pass);
    }
}
