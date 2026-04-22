package Week_06;

//atomicInteger ****count.incrementandGet()

import java.util.concurrent.atomic.AtomicInteger;

public class WithAtomic {
        private static AtomicInteger count = new AtomicInteger(0);

        public static void main (String[] args) throws InterruptedException {  //need joint method toincremental running values

            Runnable Task = () -> { //Lamda for create non-class/method
                for (int i = 0; i <= 100000; i++) {
                    count.incrementAndGet();  //atomic -> thread safe
                }
            };

            Thread t1 = new Thread(Task); //simpan data/process printing
            Thread t2 = new Thread(Task);
            Thread t3 = new Thread(Task);
            Thread t4 = new Thread(Task);

            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();

            System.out.println("Final count with Atomic: " + count.get());
        }
}
