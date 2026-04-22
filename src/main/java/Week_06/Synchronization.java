package Week_06;

public class Synchronization {

    private static int count = 0;
    public static synchronized void increment() {
        count++;
    }

    public static void main (String[] args) throws InterruptedException {

        Runnable Task = () -> { //Lamda for create non-class/method
            for (int i = 0; i <= 100000; i++) {
                increment();  //synchronization -> thread safe (only one thread will be run at one time)
            }
        };

        Thread t1 = new Thread(Task);
        Thread t2 = new Thread(Task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count with Synchronization: " + count);
    }
}
