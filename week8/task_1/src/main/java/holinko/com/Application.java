package holinko.com;

import holinko.com.config.AppConfig;
import holinko.com.utils.FileWriter;
import holinko.com.utils.NewsLastTime;
import holinko.com.utils.NewsReader;
import holinko.com.utils.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Pavel
 */
@Service
public class Application
{
    private FileWriter fileWriter;
    private NewsReader newsReader;

    public Application(FileWriter fileWriter, NewsReader newsReader)
    {
        this.fileWriter = fileWriter;
        this.newsReader = newsReader;
    }

    public Application()
    {
    }

    public static void main(String[] args) throws InterruptedException
    {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("springCacheWriter.xml");
        //Uncomment this code for annotations configuration
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Application app = (Application) ctx.getBean("app");
        while (true)
        {
            for (int i = 0; i < 5; i++)
            {
                String message = app.newsReader.readNews();
                System.out.println(message);
                TimeFormat appTime = (NewsLastTime) ctx.getBean("appTime");
                message = appTime.getNewsTime(message);
                app.fileWriter.writeToFile(message);
            }
            Thread.sleep(10000);
        }
    }
}
