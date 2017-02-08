package Week3.Task_5;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by Pavel
 */
public class Football_Player implements Runnable
{
    Stadium stadium;
    private Thread thread;

    public Football_Player(Stadium stadium, int playerNum)
    {
        this.stadium = stadium;
        thread = new Thread(this, "Игрок №" + playerNum);
        thread.start();
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(thread.getName() + " пришел на стадион.");
            stadium.BARRIER.await();
            if (stadium.isRaining())
            {
                System.out.println("Сегодня дождь! Игра переносится на следующую неделю!");

            } else
            {
                System.out.println("Игра прошла успешно!");
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }

    public Thread getThread()
    {
        return thread;
    }
}

