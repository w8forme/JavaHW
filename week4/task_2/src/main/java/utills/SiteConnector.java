package week4.task_2.src.main.java.utills;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Pavel
 */
public class SiteConnector
{

    public String currencyJson()
    {
        StringBuffer json = new StringBuffer();
        String answer;

        try
        {
            URL url = new URL("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
            URLConnection connection = url.openConnection();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())))
            {
                while ((answer = in.readLine()) != null)
                {
                    json.append(answer).append("\n");
                }
                return answer = json.toString();

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
