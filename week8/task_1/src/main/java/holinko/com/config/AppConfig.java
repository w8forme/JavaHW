package holinko.com.config;

import holinko.com.Application;
import holinko.com.utils.*;
import org.springframework.context.annotation.*;
import java.util.Date;

/**
 * Created by Pavel
 */
@Configuration
@ComponentScan("holinko.com")
public class AppConfig
{
    @Bean
    @Lazy
    public Application app()
    {
        return new Application(fileWriter(), newsReader());
    }

    @Bean
    @Scope("prototype")
    public TimeFormat appTime()
    {
        return new NewsLastTime(new Date());
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public FileWriter fileWriter()
    {
        return new CacheWriter(20, "ua_news.txt");
    }

    @Bean
    public NewsReader newsReader()
    {
        return new LigaNews();
    }
}
