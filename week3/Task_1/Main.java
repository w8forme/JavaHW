package week3.Task_1;

/**
 * Created by Pavel
 */
public class Main
{

    public static void main(String[] args) throws InterruptedException
    {
        //Start first thread
        MyThread thrd1 = new MyThread("Thread-1");

        //Wait until thread 1 is end his work
        thrd1.getThread().join();

        //Start second and third threads after thread 1 is completed
        MyThread thrd2 = new MyThread("Thread-2");
        MyThread thrd3 = new MyThread("Thread-3");

        //Wait for threads 2 and 3
        thrd2.getThread().join();
        thrd3.getThread().join();

        MyThread thrd4 = new MyThread("Thread-4");
    }
}
