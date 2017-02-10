package Week3.Task_2;

/**
 * Created by Pavel
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        Storage st = new Storage();
        Producer farmer = new Producer(st, "Фермер Вася");
        Thread.sleep(10000);
        Shop shop1 = new Shop(st, 5000, "Магазин яблок №1");
        Shop shop2 = new Shop(st, 10000, "Магазин яблок №2");


    }
}
