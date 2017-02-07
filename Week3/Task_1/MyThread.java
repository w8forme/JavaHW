package Week3.Task_1;

/**
 * Created by Pavel
 */
public class MyThread implements Runnable
{
    private Thread thread;



    public MyThread(String name)
    {
        thread = new Thread(this, name);
        thread.start();
}

    @Override
    public void run()
    {
        int lifeTime;
        double result = 0;
        System.out.println("Старт потока: " + thread.getName());
        for (int i = 0; i < 5; i++)
        {
            try
            {
                lifeTime = (int)(Math.random() * 4000) + 1000;
                thread.sleep(lifeTime);
                result += lifeTime;
                System.out.printf("Поток %s работает: %.1f секунд\n", thread.getName(), result / 1000);
            } catch (InterruptedException e)
            {
                System.out.println("Прерывание потока " + thread.getName());
            }
        }
        System.out.printf("Поток %s завершил работу за %.1f секунд.\n", thread.getName(), result / 1000);
    }

    public Thread getThread()
    {
        return thread;
    }

    public void setThread(Thread thread)
    {
        this.thread = thread;
    }
}
