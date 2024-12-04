package Labs.lab7.number2;

import java.util.concurrent.*;

public class MaxTask implements Callable<Integer> {
    private int[] row;

    public MaxTask(int[] row) {
        this.row = row;
    }

    @Override
    public Integer call() {
        int max = Integer.MIN_VALUE;
        for (int value : row) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
