package Week_06;

// use the data 100,000 increments

public class WithoutAtomic {
    private static int count = 0;

    public static void main (String[] args) throws InterruptedException {  //need joint method to incremental running values

        Runnable Task = () -> { //Lamda for create non-class/method
            for (int i = 0; i <= 100000; i++) {
                count++;  //not atomic -> race condition
            }
        };

            Thread t1 = new Thread(Task); //simpan data/process printing
            Thread t2 = new Thread(Task);

            t1.start();
            t2.start();

            t1.join();
            t2.join();

        System.out.println("Final count with no Atomic: " + count);
    }
}
