package Week_09.Exercise6;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Long> {
    private int[] numbers;
    private int start, end;
    private static final int THRESHOLD = 1000;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;

        if (length <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }
        // Requirement 2: If more than the threshold, split the array, fork one,
        // compute the other directly, then join.
        else {
            int mid = start + (length / 2);
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);

            // Fork one subtask
            leftTask.fork();

            // Compute the other directly
            Long rightResult = rightTask.compute();

            // Join and return the combined result
            Long leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}

public class MyForkJoin {
    public static void main(String[] args) {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) nums[i] = i;

        ForkJoinPool pool = new ForkJoinPool();
        long result = pool.invoke(new SumTask(nums, 0, nums.length));

        System.out.println("Total sum: " + result);
    }
}
