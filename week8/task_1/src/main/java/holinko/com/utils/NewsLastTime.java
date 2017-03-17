package holinko.com.utils;

/**
 * Created by Pavel
 */
import java.util.Date;

public class NewsLastTime implements TimeFormat
{
    private Date date;

    public NewsLastTime(Date date){
        this.date = date;
        System.out.println("In constr NewsLastTime");
    }

    @Override
    public String getNewsTime(String str)
    {
        return date + ": " + str;
    }
}
