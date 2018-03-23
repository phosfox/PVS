package ex_05;

import java.util.concurrent.RecursiveTask;

public class ForkJoinWorker extends RecursiveTask<Integer>{
    private static int LOWERBOUND = 4;
    private final int[] array;
    private final int start, end;

    int ans = 0;

    public int getSum() {
        return ans;
    }

    public ForkJoinWorker(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start <= LOWERBOUND){
            for(int i = start; i < end; ++i){
                ans += 1 / array[i];
            }
        }else{
            ForkJoinWorker left = new ForkJoinWorker(array, start, (end + start)/2);
            ForkJoinWorker right = new ForkJoinWorker(array, (end + start) /2, end);
            left.fork();
            right.compute();
            left.join();
            ans = left.ans + right.ans;
        }
        return ans;
    }
}
