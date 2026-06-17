package Week_13;

import java.util.*;
import java.util.concurrent.*;

public class CallableQuiz {
    static volatile boolean quizOpen = true;

    public static void main(String[] args) throws Exception {
        ThreadGroup studentGroup = new ThreadGroup ("Students");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                quizOpen = false;
                System.out.println("\nQuiz submission CLOSED!");
            }
        }, 5000);

        //Executor Service
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<String>> results = new ArrayList<>();

        for(int i= 1; i <= 5; i++){
            Callable<String> studentTask = () -> {
                Thread.currentThread().setName("Student-" + Thread.currentThread().getId());
                String name = Thread.currentThread().getName();

                int time = (int)(Math.random() * 8000);
                Thread.sleep(time);

                if (quizOpen){
                    return name + " submitted ON TIME";
                } else {
                    return name + " submitted LATE";
                }
            };
            results.add(executor.submit(studentTask));
        }
        System.out.println("\nLecturer Checking Results:");

        for(Future<String> result: results){
            System.out.println(result.get());
        }

        executor.shutdown();
        timer.cancel();

        System.out.println("\nQuiz session ended.");
    }
}
