package Week_07;

import java.util.concurrent.locks.ReentrantReadWriteLock;
public class AfterReentrantReadWriteLock {
    private static int counter = 0;

    private static final ReentrantReadWriteLock Lock =
            new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {  //Lambda to create non-class/method
            for(int i =0; i < 100000; i++) {
                Lock.writeLock().lock(); // 2. acquire for lock before accessing shared resources

                // 3. to protect by ReentrantLock
                try {
                    counter++; //incrementAndGet() - in presenting Atomic & Synchronization
                } finally {
                    Lock.writeLock().unlock(); //always release lock after run/after use
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");
        Thread t4 = new Thread(task, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        //Read Operation using read lock
        Lock.readLock().lock();
        try {
            System.out.println("Final Counter (ReadWriteLock): " + counter);
        } finally {
            Lock.readLock().unlock();
        }
    }
}
