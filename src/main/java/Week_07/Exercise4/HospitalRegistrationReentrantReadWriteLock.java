package Week_07.Exercise4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class HospitalRegistrationReentrantReadWriteLock {
    private static int totalPatients =0;

    //create the ReentrantReadWriteLock
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final Lock writeLock = lock.writeLock();

    public static void main(String[] args) throws InterruptedException {

        Runnable registerPatient = () -> {
            for (int i = 0; i < 1000000; i++) {
                writeLock.lock();

                try{
                    totalPatients++;
                } finally{
                    writeLock.unlock();
                }
            }
        };

        Thread counter1 = new Thread(registerPatient, "Counter-1");
        Thread counter2 = new Thread(registerPatient, "Counter-2");

        counter1.start();
        counter2.start();

        counter1.join();
        counter2.join();
        System.out.println("Total registered patients : " + totalPatients);
    }
}
