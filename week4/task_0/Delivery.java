package week4.task_0;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pavel
 */
public class Delivery implements Runnable
{
    private Apoint a;
    private Bpoint b;
    private boolean startA;


    public Delivery(Apoint a, Bpoint b, boolean startA)
    {
        this.a = a;
        this.b = b;
        this.startA = startA;
    }

    public void run()
    {

            try
            {
                if (startA)
                {
                    a.takePackeges();
                    System.out.println("Грузовик забрал посылку и отправился из пункта А в пункт Б. " + this);
                    Thread.sleep(1000);
                    b.putPackeges();
                    System.out.println("Выгрузил посылку в пункте В " + this);
                    startA = false;
                } else
                {
                    b.takePackeges();
                    System.out.println("Грузовик забрал посылку и отправился из пункта В в пункт А. " + this);
                    Thread.sleep(3000);
                    a.putPackeges();
                    System.out.println("Выгрузил посылку в пункте А " + this);
                    startA = true;
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }

    }

    @Override
    public String toString()
    {
        return "Грузовик " + Thread.currentThread().getName();
    }
}
