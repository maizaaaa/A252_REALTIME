package Week_04.Interrupt;

public class InterruptThread extends Thread {
    private String name;

    public InterruptThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println(name + " : " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
    }
}
