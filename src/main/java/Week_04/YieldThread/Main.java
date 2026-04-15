package Week_04.YieldThread;

public class Main {
    public static void main(String[] args) {

        YieldThread t1 = new YieldThread("Thread 1");
        YieldThread t2 = new YieldThread("Thread 2");
        YieldThread t3 = new YieldThread("Thread 3");
        YieldThread t4 = new YieldThread("Thread 4");
        YieldThread t5 = new YieldThread("Thread 5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
