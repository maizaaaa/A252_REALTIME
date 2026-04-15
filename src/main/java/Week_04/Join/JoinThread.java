package Week_04.Join;

public class JoinThread extends Thread {
    private String name;

    public JoinThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(name + " : " + i);
        }
    }
}
