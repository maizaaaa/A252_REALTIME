package Week_13;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadGroupTimerApplication {
    static volatile boolean quizOpen = true;

    public static void main(String[] args) throws Exception {
        ThreadGroup studentGroup = new ThreadGroup ("Students");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run(){
                quizOpen = false;
                System.out.println("\nQuiz submission CLOSED!");
            }
        }, 5000);

        Runnable studentTask = () -> {
            String name = Thread.currentThread().getName();

            try{
                int time = (int) (Math.random() * 8000);
                Thread.sleep(time);

                if (quizOpen) {
                    System.out.println(name + " submitted on time");
                } else {
                    System.out.println(name + " submitted late");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        };

        for (int i=0; i<=5; i++){
            Thread student = new Thread(studentGroup, studentTask, "Student-" + i);

            student.start();
        }

        while (studentGroup.activeCount() > 0) {
            System.out.println("Active Students: " + studentGroup.activeCount());

            Thread.sleep(1000);
        }

        timer.cancel();

        System.out.println("\nAll students finished.");
    }
}
