package week3.Task_2;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Pavel
 */
public class Shop implements Runnable
{
    private List<Apple> applesInShop; //The list with all apples in shop
    private int quantityApples; //Amount apples in shop
    private int sellSpeed; //Bigger number will increase sleep time for thread
    private Thread thread;
    Storage storage; //Link for our storage

    public Shop(Storage storage, int sellSpeed, String threadName)
    {
        thread = new Thread(this, threadName);
        thread.start();
        this.sellSpeed = sellSpeed;
        this.storage = storage;
    }

    //Method for delivering apples to the shop
    private void delivery()
    {
        try
        {
            this.applesInShop = storage.sellApples();
            for (Apple apple : applesInShop)
            {
                quantityApples += apple.getAppleQuantity(); //Count how many apples we receive frm storage
            }
        } catch (InterruptedException e)
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
                    count = apple.getAppleQuantity(); // Amount sort of apples
                    howMuchSell += count; // How much apples were sold
                    quantityApples -= count; // How much apples left at the shop
                    iterator.remove(); //Remove apples that were sold
                    System.out.printf((char) 27 + "[31m" + thread.getName() + (char) 27 + "[0m" + ": Продали %d яблок сорта %s\n\n", count, apple.getAppleName());
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.printf((char) 27 + "[31m" + thread.getName() + (char) 27 + "[0m" + ": Все яблоки проданы! Всего было продано %d яблок.\n\n", howMuchSell);
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
                    System.out.printf("Продали в %s, %d яблок.\n", (char) 27 + "[31m" + thread.getName() + (char) 27 + "[0m", quantityApples);
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
