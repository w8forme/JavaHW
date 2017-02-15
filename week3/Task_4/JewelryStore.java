package week3.Task_4;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by Pavel
 *
 */
public class JewelryStore
{
    private CountDownLatch startShopping;
    private Semaphore semaphore;
    private volatile int customersInShop;

    private JewelryStore()
    {
        startShopping = new CountDownLatch(5);
        semaphore = new Semaphore(5, true);
        customersInShop = 0;
    }

    public static JewelryStore getInstance()
    {
        return JewelryStoreHolder.HOLDER_INSTANCE;
    }

    private static class JewelryStoreHolder
    {
        private static final JewelryStore HOLDER_INSTANCE = new JewelryStore();
    }

    public CountDownLatch getStartShopping()
    {
        return startShopping;
    }

    public Semaphore getSemaphore()
    {
        return semaphore;
    }

    public int getCustomersInShop()
    {
        return customersInShop;
    }

    public synchronized void incCustomersInShop()
    {
        customersInShop++;
    }

    public synchronized void decCustomersInShop()
    {
        customersInShop--;
    }
}
