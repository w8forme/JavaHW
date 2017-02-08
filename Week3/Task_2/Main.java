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
        Shop_1 shop1 = new Shop_1(st, 5000, "Магазин яблок №1");
        Shop_1 shop2 = new Shop_1(st, 10000, "Магазин яблок №2");


    }
}
