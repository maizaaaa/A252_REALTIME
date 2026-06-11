package Week_07;

public class BeforeReentrantLock { //will get random count
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {  //Lambda to create non-class/method
            for(int i =0; i < 100000; i++) {
                count++; //for no ReentrantLock
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter (No Lock): " + count);
    }
}
