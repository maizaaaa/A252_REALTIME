package Week_07.Execise2;

public class LibraryBorrowing {
    private static String studentName = null;

    public static void borrowBook(String studentName, String bookTitle) {
        System.out.println(studentName + " is borrowing: " + bookTitle);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(studentName + " has finished borrowing: " + bookTitle);
    }

    public static void main(String[] args) {
        Runnable student1 = () -> {
            borrowBook("Amiza", "If Only I Had Told Her");
            borrowBook("Amiza", "The List");
        };

        Runnable student2 = () -> {
            borrowBook("Munawwir", "Nirnama");
        };

        Runnable student3 = () -> {
            borrowBook("Husna", "Jangan Kacau Aku Boleh Tak?");
        };

        Thread t1 = new Thread(student1, "Student-Amiza");
        Thread t2 = new Thread(student2, "Student-Munawwir");
        Thread t3 = new Thread(student3, "Student-Husna");

        t1.start();
        t2.start();
        t3.start();
    }
}
