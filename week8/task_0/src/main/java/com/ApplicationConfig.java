package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by Pavel
 */
@Configuration
public class ApplicationConfig
{

    @Bean
    @Lazy
    public Application app()
    {
        return new Application(doWriter(), doMessenger());
    }

    @Bean
    public Messenger doMessenger()
    {
        return new MessengerImpl();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Writer doWriter()
    {
        return new CacheWriter(5, "storage.txt");
    }

    @Bean
    @Scope("prototype")
    public MessLastTime appTime()
    {
        return new MessLastTime(new Date());
    }
}
