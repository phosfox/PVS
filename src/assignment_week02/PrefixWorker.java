package assignment_week02;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class PrefixWorker implements Callable<int[]> {
    private int[] data;
    private int start,end;

    public PrefixWorker(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public int[] call() {
        for (int i = start + 1; i <= end; i++) {
            data[i] += data[i - 1];
        }
        return data;
    }


}
