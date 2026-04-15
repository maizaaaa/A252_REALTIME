package Week_04.YieldThread;

import java.security.spec.RSAOtherPrimeInfo;

public class YieldThread extends Thread{
    private String name;

    public YieldThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i <= 5; i++){
            System.out.println(name + " : " + i);

            Thread.yield();
        }
    }

    public void start(){
        for (int i = 0; i <= 5; i++){
            System.out.println(name + " is printing number: " + i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
