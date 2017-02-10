package Week3.Task_3;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Pavel
 */
public class AutoShop
{
    private static final CountDownLatch START = new CountDownLatch(11);
    private static final int AUCTION_DURATION = 900000;
    private volatile int carsQuantity;

    //Method for counting cars
    public void carsCount() throws InterruptedException
    {
        for (int i = 1; i <= 5; i++)
        {
            System.out.println("Считаем машины: " + i);
            carsQuantity = i;
            Thread.sleep(2000);
        }
        START.countDown();
        System.out.println("Все машины посчитаны! Можно начинать аукцион!");
    }

    private AutoShop()
    {
        carsQuantity = 0;
    }

    public static AutoShop getInstance()
    {
        return AutoShopHolder.HOLDER_INSTANCE;
    }

    static class AutoShopHolder
    {
        private static final AutoShop HOLDER_INSTANCE = new AutoShop();
    }

    public static CountDownLatch getSTART()
    {
        return START;
    }

    public static int getAuctionDuration()
    {
        return AUCTION_DURATION;
    }

    public int getCarsQuantity()
    {
        return carsQuantity;
    }

    public synchronized void setCarsQuantity()
    {
        carsQuantity--;
    }
}
