package week4.task_0.src.main.java;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        Apoint a = new Apoint();
        Bpoint b = new Bpoint();

        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(5);
        ScheduledExecutorService service2 = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 5; i++)
        {
            service1.scheduleWithFixedDelay(new Delivery(a, b, true), 0, 1, TimeUnit.SECONDS);
            for (int j = 0; j < 2; j++)
            {
                service2.scheduleWithFixedDelay(new Delivery(a, b, false), 0, 1, TimeUnit.SECONDS);
            }
        }


    }
}
