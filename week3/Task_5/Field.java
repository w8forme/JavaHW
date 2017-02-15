package week3.Task_5;

/**
 * Created by Pavel
 */
public class Field implements Runnable
{
    Stadium stadium;

    public Field(Stadium stadium)
    {
        this.stadium = stadium;
    }

    @Override
    public void run()
    {
        try
        {
            if (stadium.isRaining())
            {
                Thread.sleep(1000);
                System.out.println("Поле не готово для игры!");
                Stadium.played = false;
            }
            else
            {
                Thread.sleep(1000);
                System.out.println("Поле готово для игры!");
                Stadium.played = true;
            }
        } catch (InterruptedException e)
        {
        }
    }
}
