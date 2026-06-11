package Week_11;

import java.util.concurrent.ConcurrentHashMap;

public class CountEvenNumbersMap {
    static ConcurrentHashMap<Integer, String> map =
            new ConcurrentHashMap<>();

    public static void main(String[] args)
            throws InterruptedException {

        Runnable task = () -> {

            String threadName =
                    Thread.currentThread().getName(); //.getName() to retrieve the current thread
            for (int i = 1; i <= 100; i++) {

                if (i % 2 == 0) {

                    //evenNumbers.add(i);
                    map.put(i, threadName);

                }
            }
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map);
    }
}
