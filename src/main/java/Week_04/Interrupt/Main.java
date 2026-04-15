package Week_04.Interrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        InterruptThread t1 = new InterruptThread("T1");
        InterruptThread t2 = new InterruptThread("T2");
        InterruptThread t3 = new InterruptThread("T3");
        InterruptThread t4 = new InterruptThread("T4");
        InterruptThread t5 = new InterruptThread("T5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(2000);

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
    }
}
