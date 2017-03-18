package holinko.com.utils;

/**
 * Created by Pavel
 */
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class NewsLastTime implements TimeFormat
{
    private Date date;

    public NewsLastTime(Date date){
        this.date = date;
    }

    public NewsLastTime(){}

    @Override
    public String getNewsTime(String str)
    {
        return date + ": " + str;
    }
}
