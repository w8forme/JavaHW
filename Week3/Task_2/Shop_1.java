package Week3.Task_2;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Pavel
 */
public class Shop_1 implements Runnable
{
    private List<Apple> applesInShop; //The list with all apples in shop
    private int quantityApples; //Amount apples in shop
    private int sellSpeed; //Bigger number will increase sleep time for thread
    private String threadName;
    private Thread thread;

    public Shop_1(int sellSpeed, String threadName)
    {
        thread = new Thread(this, threadName);
        thread.start();
        this.sellSpeed = sellSpeed;
        this.threadName = threadName;
    }

    private void delivery()
    {
        try
        {
            this.applesInShop = Storage.getInstance().sellApples();
            if (applesInShop != null || !applesInShop.isEmpty())
            {
                for (Apple apple : applesInShop)
                {
                    quantityApples += apple.getAppleQuantity();
                }
            }
            else
            {
                thread.sleep(500);
                System.out.printf("Жду яблок\n\n");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void sellToCustomers()
    {
        int count; //Counter for apples
        int howMuchSell = 0; //How much sells the apples
        if (applesInShop != null && !applesInShop.isEmpty())
        {
            for (Iterator<Apple> iterator = applesInShop.iterator(); iterator.hasNext(); )
            {
                Apple apple = iterator.next();
                try
                {
                    thread.sleep(sellSpeed); // Shop sell speed
                    System.out.println(thread.getName()); // Name of shop
                    count = apple.getAppleQuantity(); // Amount sort of apples
                    howMuchSell += count; // How much apples were sold
                    quantityApples -= count; // How much apples left at the shop
                    iterator.remove(); //Remove apples that were sold
                    System.out.printf("Продали %d яблок сорта %s\n\n", count, apple.getAppleName());
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.printf("Все яблоки проданы! Всего было продано %d яблок.\n\n", howMuchSell);
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                thread.sleep(5000);
                if (applesInShop != null && !applesInShop.isEmpty())
                {
                    sellToCustomers();
                } else
                {
                    delivery();
                    System.out.printf("Продали в %s, %d яблок.\n", thread.getName(), quantityApples);
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
