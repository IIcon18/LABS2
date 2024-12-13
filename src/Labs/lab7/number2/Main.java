package Labs.lab7.number2;

import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7},
                {2, 8, 6},
                {3, 9, 5}
        };

        int numRows = matrix.length;
        ExecutorService executor = Executors.newFixedThreadPool(numRows);
        Future<Integer>[] futures = new Future[numRows];

        for (int i = 0; i < numRows; i++) {
            futures[i] = executor.submit(new MaxTask(matrix[i]));
        }

        int globalMax = Integer.MIN_VALUE;

        for (Future<Integer> future : futures) {
            try {
                int rowMax = future.get();
                if (rowMax > globalMax) {
                    globalMax = rowMax;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}
