package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Application
{
    private Writer writer;
    private Messenger messenger;

    public Application(Writer writer, Messenger messenger)
    {
        this.writer = writer;
        this.messenger = messenger;
    }

    public Application()
    {
    }

    public static void main(String[] args) throws InterruptedException
    {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        //Uncomment this code for annotations configuration
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Application app = (Application) ctx.getBean("app");
        for (int i = 0; i < 12; i++)
        {
            String message = app.messenger.getMessage();
            MessLastTime appTime = (MessLastTime) ctx.getBean("appTime");
            message = appTime.getMessLastTime(message);
            app.writer.write(message);
        }
        ctx.close();
    }
}

