package Week_09.Excercise5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class GradeCountTask extends RecursiveTask<int[]> {
    private int[] scores;
    private int start;
    private int end;
    private static final int THRESHOLD = 5;

    public GradeCountTask(int[] scores, int start, int end) {
        this.scores = scores;
        this.start = start;
        this.end = end;
    }

    @Override
    protected int[] compute() {
        int length = end - start;

        int[] gradeCounts = new int[5];

        if (length <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                int score = scores[i];
                if (score >= 85) {
                    gradeCounts[0]++;
                } else if (score >= 70) {
                    gradeCounts[1]++;
                } else if (score >= 55) {
                    gradeCounts[2]++;
                } else if (score >= 40) {
                    gradeCounts[3]++;
                } else {
                    gradeCounts[4]++;
                }
            }
            return gradeCounts;
        }
        else {
            int mid = start + (length / 2);
            GradeCountTask leftTask = new GradeCountTask(scores, start, mid);
            GradeCountTask rightTask = new GradeCountTask(scores, mid, end);

            // Execute left task asynchronously
            leftTask.fork();

            // Execute right task in current thread
            int[] rightResult = rightTask.compute();

            // Wait for left task and get its result
            int[] leftResult = leftTask.join();

            // Combine results by summing corresponding grade counts
            int[] combinedCounts = new int[5];
            for (int i = 0; i < 5; i++) {
                combinedCounts[i] = leftResult[i] + rightResult[i];
            }

            return combinedCounts;
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        int[] scores = {75, 88, 92, 55, 63, 79, 100, 82, 45, 38, 67, 73, 89, 95, 50};

        ForkJoinPool pool = new ForkJoinPool();
        int[] finalCounts = pool.invoke(new GradeCountTask(scores, 0, scores.length));

        System.out.println("Final Exam Grade Counts:");
        System.out.println("Grade A (85-100): " + finalCounts[0]);
        System.out.println("Grade B (70-84): " + finalCounts[1]);
        System.out.println("Grade C (55-69): " + finalCounts[2]);
        System.out.println("Grade D (40-54): " + finalCounts[3]);
        System.out.println("Grade F (0-39): " + finalCounts[4]);
    }
}
