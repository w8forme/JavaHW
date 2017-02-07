package Week3.Task_2;

/**
 * Created by Pavel
 */
public class Main
{

    public static void main(String[] args)
    {
        Producer farmer = new Producer("Фермер Вася");
        Storage storeHouse = Storage.getInstance();
        Shop_1 shop1 = new Shop_1(5000, "Магазин яблок №1");
        //Shop_1 shop2 = new Shop_1(10000, "Магазин яблок №2");


    }
}
