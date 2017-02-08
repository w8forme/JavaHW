package Week3.Task_5;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Pavel
 */
public class Stadium
{
    private boolean raining;
    public static boolean played = false;
    public final CyclicBarrier BARRIER = new CyclicBarrier(10, new Field(this));

    public void weatherGenerator()
    {
        raining = Math.random() < 0.5;
        if (raining)
        {
            System.out.println("Сегодня идет дождь!");
        }
        else
        {
            System.out.println("Сегодня ясная погода!");
        }
    }

    public void gameCounter() throws InterruptedException
    {
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(i + "-й день недели.");
            Thread.sleep(1000);
        }
    }

    public boolean isRaining()
    {
        return raining;
    }

    public static void main(String[] args)
    {
        Stadium st = new Stadium();

        while (true)
        {
            if (!Stadium.played)
            {
                try
                {
                    st.gameCounter();
                    st.weatherGenerator();
                    for (int i = 1; i <= 10; i++)
                    {
                        new Football_Player(st, i);
                        Thread.sleep(1000);
                    }
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            } else
            {
                return;
            }
        }
    }
}
