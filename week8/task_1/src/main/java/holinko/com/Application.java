package holinko.com;

import holinko.com.utils.FileWriter;
import holinko.com.utils.NewsReader;
import holinko.com.utils.TimeFormat;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Pavel
 */
public class Application
{
    private FileWriter fileWriter;
    private NewsReader newsReader;
    private TimeFormat timeFormat;

    public Application(FileWriter fileWriter, NewsReader newsReader, TimeFormat timeFormat)
    {
        this.fileWriter = fileWriter;
        this.newsReader = newsReader;
        this.timeFormat = timeFormat;
        System.out.println("in Application constr");
    }

    public static void main(String[] args) throws InterruptedException
    {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springCacheWriter.xml");
        Application app = (Application) ctx.getBean("app");
        while (true)
        {
            for (int i = 0; i < 5; i++)
            {
                String message = app.newsReader.readNews();
                System.out.println(message);
                message = app.timeFormat.getNewsTime(message);
                app.fileWriter.writeToFile(message);
            }
            Thread.sleep(10000);
        }
        //ctx.close();
    }
}
