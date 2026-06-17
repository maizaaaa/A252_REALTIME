package Week_13;

import java.util.concurrent.*;

public class ThreadGroupApplication {
    static BlockingQueue<String> submissionQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws Exception {
        ThreadGroup studentGroup = new ThreadGroup("Student Group");

        Runnable studentTask = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " joined the lab");

            try{
                Thread.sleep((long)(Math.random()* 3000));

                submissionQueue.put(name);

                System.out.println(name + " submitted assignment");
            } catch (Exception e){
                e.printStackTrace();
            }
        };

        for (int i=1; i<=5; i++){
            Thread student = new Thread (studentGroup,studentTask, "Student-" + i);

            student.start();
        }
        while (studentGroup.activeCount() > 0){
            System.out.println("Active students: " + studentGroup.activeCount());
            Thread.sleep(1000);
        }
        System.out.println("All students completed submission.");
    }
}
