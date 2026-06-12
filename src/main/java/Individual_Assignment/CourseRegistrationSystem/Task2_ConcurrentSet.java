package Individual_Assignment.CourseRegistrationSystem;

import Individual_Assignment.data.RegistrationData;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Task2_ConcurrentSet {
    public static void main(String[] args) {
        Set<String> courseSet = ConcurrentHashMap.newKeySet();

        System.out.println("============================================");
        System.out.println("               Concurrent Set              ");
        System.out.println("============================================");

        String[] courseCodes = RegistrationData.COURSES;

        System.out.println("--- Adding Course Codes ---");
        for (String code : courseCodes){
            courseSet.add(code);
        }
        System.out.println("Successfully added " + courseSet.size() + " initial courses.\n");

        System.out.println("--- Attempting to Add Duplicates ---");
        boolean isAdded1 = courseSet.add("STIAK1013");
        boolean isAdded2 = courseSet.add("STIWK3114");

        System.out.println("Attempting to add duplicate 'STIAK1013': " + (isAdded1 ? "Success" : "Failed"));
        System.out.println("Attempting to add duplicate 'STIWK3114': " + (isAdded2 ? "Success" : "Failed"));
        System.out.println("Current Set Size remains: " + courseSet.size() + "\n");

        System.out.println("--- Display Unique Course Codes ---");
        for (String code : courseSet){
            System.out.println(code);
        }
        System.out.println("\n\n");

        System.out.println("--- Course Exists ---");
        String checkCourse = "STIWK3014";
        System.out.println("Does '" + checkCourse + "' exist? " + courseSet.contains(checkCourse) + "\n");

        System.out.println("--- Remove Course ---");
        String removeCourse = "STIKK2114";
        boolean isRemoved = courseSet.remove(removeCourse);
        System.out.println("Removing '" + removeCourse + "' from Course Set: " + (isRemoved ? "Success" : "Failed"));

        System.out.println("Final Set Size after removal: " + courseSet.size() + "\n");
    }
}


