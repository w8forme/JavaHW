package Week3.Task_3;


/**
 * Created by Pavel
 */
public class Buyer implements Runnable
{

    private Thread thread;

    public Buyer(String threadName)
    {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void run()
    {
        try
        {
            int reaction = (int) (Math.random() * 5000 + 1000);
            thread.sleep((reaction));
            System.out.println(thread.getName() + " прибыл на аукцион!");
            AutoShop.getSTART().countDown();
            AutoShop.getSTART().await();
            thread.sleep(AutoShop.getAuctionDuration() / reaction);
            if (AutoShop.getInstance().getCarsQuantity() > 0)
            {
                AutoShop.getInstance().setCarsQuantity(); //Decrease quantity of cars by 1, when somebody buys a car
                System.out.println(thread.getName() + " купил себе новенький автомобиль!");
            }
            else
            {
                System.out.println(thread.getName() + " не смог купить автомобиль!");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
