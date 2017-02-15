package week3.Task_0;


public class Shop {
    //Создаем CountDownLatch на 8 "условий"
    private static final int shopSize = 500000;
    private static boolean isOpen = false;

    public synchronized void waitForOpening() throws InterruptedException
    {
        while (!isOpen)
        {
            wait();
        }
    }
    public synchronized boolean manager()
    {
        System.out.println("Ларёк открыт!");
        isOpen = true;
        notifyAll();
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        Shop s = new Shop();
        for (int i = 1; i <= 3; i++) {
            new Thread(new drunkMan(i,(int) (Math.random() * 100 + 50), s)).start();
            Thread.sleep(1000);
        }


            Thread.sleep(100);              //у стартовой прямой. Если нет, ждем 100ms


        Thread.sleep(1000);
        s.manager();
        //Команда дана, уменьшаем счетчик на 1
        //счетчик становится равным нулю, и все ожидающие потоки
        //одновременно разблокируются
    }

    public static class drunkMan implements Runnable {
        private int costumerNum;
        private int buyTime;
        private Shop shop;

        public drunkMan(int customerNum, int buyTime, Shop shop) {
            this.costumerNum = customerNum;
            this.buyTime = buyTime;
            this.shop = shop;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Покупатель №%d пришел в ларёк за пивом\n", costumerNum);

                shop.waitForOpening();
                Thread.sleep(1000);

                shop.waitForOpening();



                Thread.sleep(shopSize / buyTime);
                System.out.printf("Покупатель №%d купил пивка\n", costumerNum);

            } catch (InterruptedException e) {
            }
        }
    }
}