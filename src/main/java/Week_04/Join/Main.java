package Week_04.Join;

public class Main {
    public static void main(String[] args)  throws InterruptedException {

        JoinThread t1 = new JoinThread("T1");
        JoinThread t2 = new JoinThread("T2");
        JoinThread t3 = new JoinThread("T3");
        JoinThread t4 = new JoinThread("T4");
        JoinThread t5 = new JoinThread("T5");

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        t4.start();
        t4.join();

        t5.start();
        t5.join();

    }
}
