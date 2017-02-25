package week5.utills;

import java.sql.*;

/**
 * Created by Pavel
 */
public class JdbcUtils
{

    public static void init(String driver) throws ClassNotFoundException
    {
        Class.forName(driver);
    }

    public static Connection getConnection(String url, String login, String pass) throws ClassNotFoundException, SQLException
    {
        return DriverManager.getConnection(url, login, pass);
    }

    public static void closeQuietly(ResultSet rs)
    {
        if (null != rs)
        {
            try
            {
                rs.close();
            } catch (SQLException e)
            {
                //NOP
            }
        }
    }

    public static void closeQuietly(PreparedStatement pst)
    {
        if (null != pst)
        {
            try
            {
                pst.close();
            } catch (SQLException e)
            {
                //NOP
            }
        }
    }

    public static void closeQuietly(Connection conn)
    {
        if (null != conn)
        {
            try
            {
                conn.close();
            } catch (SQLException e)
            {
                //NOP
            }
        }
    }
}
