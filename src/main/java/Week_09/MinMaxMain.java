package Week_09;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.Arrays;

class MinMaxTask extends RecursiveTask<int[]> {
    private int[] array;
    private int start;
    private int end;
    private static final int THRESHOLD = 4;

    public MinMaxTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected int[] compute() {
        int length = end - start;

        if (length <= THRESHOLD) {
            int min = array[start];
            int max = array[start];
            for (int i = start + 1; i < end; i++) {
                if (array[i] < min) min = array[i];
                if (array[i] > max) max = array[i];
            }
            return new int[]{min, max};
        }
        else {
            int mid = start + (length / 2);
            MinMaxTask leftTask = new MinMaxTask(array, start, mid);
            MinMaxTask rightTask = new MinMaxTask(array, mid, end);

            leftTask.fork();

            int[] rightResult = rightTask.compute();
            int[] leftResult = leftTask.join();

            int finalMin = Math.min(leftResult[0], rightResult[0]);
            int finalMax = Math.max(leftResult[1], rightResult[1]);

            return new int[]{finalMin, finalMax};
        }
    }
}

public class MinMaxMain {
    public static void main(String[] args) {
        int[] data = {12, 5, 88, 19, 20, 3, 40, 7, 18, 21, 50, 60};

        ForkJoinPool pool = new ForkJoinPool();
        int[] result = pool.invoke(new MinMaxTask(data, 0, data.length));

        System.out.println("Array: " + Arrays.toString(data));
        System.out.println("Minimum Value: " + result[0]);
        System.out.println("Maximum Value: " + result[1]);
    }
}

