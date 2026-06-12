package Individual_Assignment.CourseRegistrationSystem;

import Individual_Assignment.data.RegistrationData;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class Task1_ConcurrentList {
    public static void main(String[] args) {
        List<String> registrationList = new CopyOnWriteArrayList<>();

        System.out.println("============================================");
        System.out.println("               Concurrent List              ");
        System.out.println("============================================");

        String[] courses = RegistrationData.COURSES;
        String[] studentIDs = RegistrationData.STUDENT_IDS;

        System.out.println("--- Adding Registration Records ---");

        int courseIndex = 0;

        for (int i = 0; i < studentIDs.length; i++) {

            for (int j = 0; j < 3; j++) {
                String record = "StudentID-" + studentIDs[i] + " : " + courses[courseIndex];
                registrationList.add(record);

                courseIndex++;

                if (courseIndex >= courses.length) {
                    courseIndex = 0;
                }
            }
        }
        System.out.println("Successfully added " + registrationList.size() + " records.\n");

        System.out.println("--- All Registration Records ---");
        for (String record : registrationList) {
            System.out.println(record);
        }
        System.out.println();

        System.out.println("--- Total Registration Requests ---");
        System.out.println("Total requests processed: " + registrationList.size() + "\n");

        System.out.println("--- Checking Course Existence ---");
        String recordToCheck = "StudentID-302410 : STIAK1013";
        boolean doesExist = registrationList.contains(recordToCheck);
        System.out.println("Does '" + recordToCheck + "' exist in the system? " + doesExist + "\n");

        System.out.println("--- Retrieving Record at Index 10 ---");
        System.out.println("Record at index 10: " + registrationList.get(10) + "\n");
    }
}


