package week3.Task_2;

/**
 * Created by Pavel
 */
public class Producer implements Runnable
{
    private Thread thread;
    Storage storage;

    //gatherDelay - gather frequency in msc, gatherTime - amount of gatherDelay cycles
    public void gatherApples(int gatherTime, int gatherDelay) throws InterruptedException
    {
        Apple sort1;
        Apple sort2;
        int gatherAmount; //How many apples gather farmer

        for (int i = 0; i < gatherTime; i++)
        {
            gatherAmount = (int) (Math.random() * 10) + 1; //Choose randomly the amount of apples
            thread.sleep(gatherDelay);
            if (i % 2 == 0)
            {
                sort1 = new Apple("Melrose", gatherAmount);
                storage.putApple(sort1);
            } else
            {
                sort2 = new Apple("Priscilla", gatherAmount);
                storage.putApple(sort2);
            }
        }
        storage.setHasApples(true);
        System.out.println("Все яблоки собраны!\n");
        thread.sleep(100);
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                gatherApples(4, 5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public Producer(Storage storage, String producerName)
    {
        this.thread = new Thread(this, producerName);
        thread.start();
        this.storage = storage;
    }
}
