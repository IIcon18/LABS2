package Labs.lab7.number1;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int partSize = array.length / numThreads;

        Future<Integer>[] futures = new Future[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * partSize;
            int end = (i == numThreads - 1) ? array.length : start + partSize;
            futures[i] = executor.submit(new SumTask(array, start, end));
        }

        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("Sum: " + sum);
    }
}
