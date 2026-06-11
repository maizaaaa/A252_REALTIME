package Week_07.Execise2;

import java.util.concurrent.locks.ReentrantLock;

public class LibraryReentrantLock {
    private static String studentName = null;

    private static final ReentrantLock borrowingCard = new ReentrantLock();

    public static void borrowBook(String studentName, String bookTitle) {
        borrowingCard.lock();
        try {
            System.out.println(" [" + studentName + "] Borrowing: \"" + bookTitle +
                    "\" | lock Count: " + borrowingCard.getHoldCount());
            Thread.sleep(1000);
            System.out.println(" [" + studentName + "] Done Borrowing: \"" + bookTitle + "\"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            borrowingCard.unlock();
        }
    }

    public static void borrowingSession(String studentName, String books) {
        System.out.println("\n" + studentName + " approaching the counter...");
        borrowingCard.lock();
        try {
            System.out.println(">> " + studentName + "acquire the borrowing card.");
            System.out.println(" Waiting students: " + borrowingCard.getQueueLength());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            borrowingCard.unlock();
            System.out.println(">> " + studentName + " returneed the borrowing card. \n");
        }
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
