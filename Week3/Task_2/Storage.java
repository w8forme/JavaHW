package Week3.Task_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
public class Storage
{
    private volatile int applesQuantity; //Total amount apples in the storage
    private volatile List<Apple> apples; //Storage for apples, which the producer gather
    private volatile boolean hasApples = false; //Is storage has apples

    public synchronized void putApple(Apple apple)
    {
        apples.add(apple);
        applesQuantity += apple.getAppleQuantity();
        System.out.printf("На склад поступило %d яблок сорта %s\n", apple.getAppleQuantity(), apple.getAppleName());
        System.out.println("Сейчас на складе всего яблок: " + applesQuantity + "\n");
        hasApples = true;
        notify();
    }

    public synchronized List<Apple> sellApples() throws InterruptedException
    {
        if (!apples.isEmpty())
        {
            List<Apple> applesToShop = new ArrayList<>(apples);
            apples.clear();
            System.out.printf("Было продано %d яблок.\n", applesQuantity);
            applesQuantity = 0;
            hasApples = false;
            return applesToShop;
        }
        else
        {
            System.out.println("На складе отсутствуют яблоки! Ожидайте!");
            while (apples.isEmpty())
            {
                wait();
            }
            return apples;
        }
    }

    // приватный конструктор - из вне нельзя будет создать объект.
    private Storage()
    {
        applesQuantity = 0;
        apples = new ArrayList<Apple>();
    }

    public static Storage getInstance()
    {
        return StorageHolder.HOLDER_INSTANCE;
    }

    static class StorageHolder
    {
        private static final Storage HOLDER_INSTANCE = new Storage();
    }

    public int getApplesQuantity()
    {
        return applesQuantity;
    }

    public void setApplesQuantity(int applesQuantity)
    {
        this.applesQuantity = applesQuantity;
    }

    public boolean isHasApples()
    {
        return hasApples;
    }

    public void setHasApples(boolean hasApples)
    {
        this.hasApples = hasApples;
    }
}
