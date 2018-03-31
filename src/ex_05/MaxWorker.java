package ex_05;

import java.util.concurrent.Callable;

public class MaxWorker implements Callable<Integer> {
    private int[]data;
    private int start;
    private int end;

    public MaxWorker(int[] data, int start, int end){
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception{
        return sum(this.data, this.start, this.end);
    }

    private int sum(int data[], int start, int end){
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += data[i];
        }

        return sum;
    }
}
