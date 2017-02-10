package Week3.Task_3;

/**
 * Created by Pavel
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        for (int i = 1; i <= 10; i++)
        {
            new Buyer("Покупатель №" + i);
            Thread.sleep(1000);
        }

        //Checking if all the cars were gathered
        while (AutoShop.getSTART().getCount() > 1)
        {
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        AutoShop.getInstance().carsCount();
    }
}
