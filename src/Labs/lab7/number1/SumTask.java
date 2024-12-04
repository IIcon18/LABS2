package Labs.lab7.number1;

import java.util.concurrent.*;

class SumTask implements Callable<Integer> {
    private int [] array;
    private int start;
    private int end;

    public SumTask(int [] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call()  {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
