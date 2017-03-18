package com;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    private Writer writer;
    private Messenger messenger;

    public Application(Writer writer, Messenger messenger) {
        this.writer = writer;
        this.messenger = messenger;
        System.out.println("In constr Application...");
    }

    public static void main(String[] args) throws InterruptedException{
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Application app = (Application) ctx.getBean("app");
        for (int i = 0; i < 14; i++) {
            String message = app.messenger.getMessage();
            MessLastTime appTime = (MessLastTime) ctx.getBean("appTime");
            message = appTime.getMessLastTime(message);
            app.writer.write(message);
        }
        ctx.close();
    }
}

