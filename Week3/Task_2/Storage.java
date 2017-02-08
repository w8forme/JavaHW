package Week3.Task_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
public class Storage
{
    private int applesQuantity; //Total amount apples in the storage
    private List<Apple> apples; //Storage for apples, which the producer gather
    private boolean hasApples; //Is storage has apples

    public synchronized void putApple(Apple apple) throws InterruptedException
    {
        while (hasApples)
        {
            String nameOfCurrentThread = Thread.currentThread().getName();
            System.out.printf((char) 27 + "[31m" + nameOfCurrentThread + (char) 27 + "[0m" + ": На складе достаточно яблок!\n");
            wait();
        }
        apples.add(apple);
        applesQuantity += apple.getAppleQuantity();
        System.out.printf("На склад поступило %d яблок сорта %s\n", apple.getAppleQuantity(), apple.getAppleName());
        System.out.println("Сейчас на складе всего яблок: " + applesQuantity);
        notifyAll();
    }

    public synchronized List<Apple> sellApples() throws InterruptedException
    {
        while (!hasApples)
        {
            String nameOfCurrentThread = Thread.currentThread().getName();
            System.out.printf((char) 27 + "[31m" + nameOfCurrentThread + (char) 27 + "[0m" + ": Жду яблок!\n");
            wait();
        }
        List<Apple> applesToShop = new ArrayList<>(apples);
        apples.clear();
        //System.out.printf("Было продано %d яблок.\n", applesQuantity);
        applesQuantity = 0;
        hasApples = false;
        notifyAll();
        return applesToShop;
    }

    public Storage()
    {
        hasApples = false;
        applesQuantity = 0;
        apples = new ArrayList<>();
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
