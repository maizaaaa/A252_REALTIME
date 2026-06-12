package Individual_Assignment.CourseRegistrationSystem;

import Individual_Assignment.data.RegistrationData;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Task4_ConcurrentQueue {

    public static void main(String[] args) {

        Queue<String> registrationQueue = new ConcurrentLinkedQueue<>();

        System.out.println("============================================");
        System.out.println("              Concurrent Queue              ");
        System.out.println("============================================\n");

        String[] students = RegistrationData.STUDENT_IDS;
        String[] courses = RegistrationData.COURSES;

        System.out.println("--- Adding Registration Requests ---");

        for (int i = 0; i < 50; i++) {

            String request =
                    "StudentID-" + students[i]
                            + " -> "
                            + courses[i];

            registrationQueue.offer(request);

            System.out.println("Added to Queue: " + request);
        }

        System.out.println("\nTotal requests waiting: "
                + registrationQueue.size());

        System.out.println("\n--- Display First Request ---");
        System.out.println("Next Request: "
                + registrationQueue.peek());

        System.out.println("\n--- 3. Process Requests (FIFO) ---");

        int count = 1;

        while (!registrationQueue.isEmpty()) {

            String processedRequest =
                    registrationQueue.poll();

            System.out.println(
                    count + ". Processing: "
                            + processedRequest);

            count++;
        }

        System.out.println("\n--- Final Status ---");
        System.out.println(
                "Queue Empty: "
                        + registrationQueue.isEmpty());
    }
}