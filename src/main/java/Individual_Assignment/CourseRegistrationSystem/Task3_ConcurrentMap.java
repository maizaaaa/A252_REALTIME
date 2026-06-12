package Individual_Assignment.CourseRegistrationSystem;

import Individual_Assignment.data.RegistrationData;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task3_ConcurrentMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> registrationMap = new ConcurrentHashMap<>();

        System.out.println("============================================");
        System.out.println("               Concurrent Map              ");
        System.out.println("============================================");

        String[] courseCodes = RegistrationData.COURSES;
        String[] students = RegistrationData.STUDENT_IDS;

        System.out.println("---  Adding 50 Student-Course Records ---");
        for (int i = 0; i < 50; i++) {
            registrationMap.put(
                    RegistrationData.STUDENT_IDS[i],
                    RegistrationData.COURSES[i]
            );
        }
        System.out.println("Successfully added " + registrationMap.size() + " records using put().\n");

        System.out.println("---  Retrieve Course by Specific Student ---");
        String searchStudent = "302755";
        System.out.println("Student " + searchStudent + " is registered for: " + registrationMap.get(searchStudent) + "\n");

        System.out.println("--- Update the Course of a Student ---");
        System.out.println("Before update, Student 302755 course: " + registrationMap.get("302755"));
        registrationMap.replace("302755", "STIZK4993");
        System.out.println("After update, Student 302755 course: " + registrationMap.get("302755") + "\n");

        System.out.println("--- Check whether a Student ID Exists ---");
        String checkStudent = "302721";
        System.out.println("Does Student ID '" + checkStudent + "' exist? " + registrationMap.containsKey(checkStudent) + "\n");

        System.out.println("--- Remove a Student Registration ---");
        System.out.println("Removing Student '" + checkStudent + "'...");
        registrationMap.remove(checkStudent);
        System.out.println("Does Student ID '" + checkStudent + "' exist now? " + registrationMap.containsKey(checkStudent));
        System.out.println("Total Map Size after removal: " + registrationMap.size() + "\n");

        System.out.println("--- Display All Registrations ---");
        for (Map.Entry<String, String> entry : registrationMap.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + " | Course: " + entry.getValue());
        }


    }
}

