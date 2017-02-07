package Week3.Task_2;

/**
 * Created by Pavel
 */
public class Producer implements Runnable
{
    private Thread thread;

    //gatherDelay - gather frequency in msc, gatherTime - amount of gatherDelay cycles
    public void gatherApples(int gatherTime, int gatherDelay) throws InterruptedException
    {
        Apple sort1;
        Apple sort2;
        int gatherAmount;
        boolean flag = Storage.getInstance().isHasApples();
        System.out.println("Собираю яблоки!");

        while (flag) ;
        {
            for (int i = 0; i < gatherTime; i++)
            {
                gatherAmount = (int) (Math.random() * 10) + 1;
                thread.sleep(gatherDelay);
                if (i % 2 == 0)
                {
                    sort1 = new Apple("Melrose", gatherAmount);
                    Storage.getInstance().putApple(sort1);
                } else
                {
                    sort2 = new Apple("Priscilla", gatherAmount);
                    Storage.getInstance().putApple(sort2);
                }
            }
        }
        System.out.println("Все яблоки собраны!");
        thread.sleep(100);
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                gatherApples(2, 1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public Producer(String producerName)
    {
        this.thread = new Thread(this, producerName);
        thread = new Thread(this, producerName);
        thread.start();
    }
}
