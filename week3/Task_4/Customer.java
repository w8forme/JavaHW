package week3.Task_4;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by Pavel
 */
public class Customer implements Runnable
{
    private int shoppingTime; //Shopping time of each buyer
    private Thread thread;
    private CountDownLatch start = JewelryStore.getInstance().getStartShopping(); //Barrier for opening the shop
    private Semaphore semaphore = JewelryStore.getInstance().getSemaphore(); //Semaphore regulates the amount of customers in the shop
    private int reaction = (int) (Math.random() * 5000 + 1000); //Delay for each customer

    //Constructor creates new thread and start it
    public Customer(String customerName)
    {
        shoppingTime = (int) (Math.random() * 8000 + 1000);
        this.thread = new Thread(this, customerName);
        thread.start();
    }

    @Override
    public void run()
    {
        try
        {
            //Check If the barrier is broken, if yes, go in the shop
            if (start.getCount() > 0)
            {
                Thread.sleep(reaction);
                System.out.println(thread.getName() + " пришел за покупками и ждёт открытия магазина.");
                start.countDown();
                start.await();
            }

            semaphore.acquire(); //Check if the shop has free places
            JewelryStore.getInstance().incCustomersInShop(); //Increase the counter of customers by 1
            System.out.println(thread.getName() + " зашел в магазин и выбирает товар.");
            Thread.sleep(reaction);

            synchronized (JewelryStore.getInstance())
            {
                //Check if the shop has enough customers
                if (JewelryStore.getInstance().getCustomersInShop() < 4)
                {
                    System.out.println("В магазине сейчас посетителей: " + JewelryStore.getInstance().getCustomersInShop() + ". Магазин закрывается на перерыв!");
                    for (int i = 1; i <= 10; i++)
                    {
                        System.out.println("Прошло " + i);
                        Thread.sleep(1000);
                    }
                }
            }
            //Buying some stuff
            Thread.sleep(shoppingTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //Decrease the counter of customers by 1
            JewelryStore.getInstance().decCustomersInShop();
            semaphore.release();
            System.out.println(thread.getName() + " купил товар и ушёл домой.");
        }
    }
}
