package Week_07.Exercise4;

import java.util.concurrent.locks.ReentrantLock;

public class HospitalRegistration {
    private static int totalPatients =0;

    //create the ReentrantLock
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable registerPatient = () -> {
            for (int i = 0; i < 1000000; i++) {
                lock.lock();
                try{
                    totalPatients++;
                } finally{
                    lock.unlock();
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
