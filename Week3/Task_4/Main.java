package Week3.Task_4;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by Pavel
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch cdl = JewelryStore.getInstance().getStartShopping();
        Semaphore sem = JewelryStore.getInstance().getSemaphore();

        for (int i = 1; i <= 4; i++)
        {
            new Customer("Покупатель №" + i);
            Thread.sleep(2000);
        }

        while (cdl.getCount() > 1)
        {
            Thread.sleep(100);
        }

        Thread.sleep(1000);
        System.out.println("Лучший ювелирный магазин Полтавы открыт!!!");
        cdl.countDown();

        for (int i = 5; i <= 100; i++)
        {
            new Customer("Покупатель №" + i);
            Thread.sleep(3000);
        }

    }
}
