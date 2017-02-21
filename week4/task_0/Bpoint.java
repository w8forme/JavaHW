package week4.task_0;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Pavel
 */
public class Bpoint
{

    private volatile int packeges;

    public Bpoint()
    {
        packeges = 10;
    }

    public synchronized int getPackeges()
    {
        return packeges;
    }

    public synchronized void putPackeges() throws InterruptedException
    {
        if (getPackeges() >= 0)
        {
            this.packeges++;
            notifyAll();
        }
        else
        {
            wait();
        }
    }

    public synchronized void takePackeges() throws InterruptedException
    {
        if (getPackeges() > 0)
        {
            this.packeges--;
            notifyAll();
        }
        else
        {
            wait();
        }
    }
}
