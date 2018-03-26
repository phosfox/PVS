package ex_05.ForkJoinVersion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinWorker {
    private static final ForkJoinPool fjPool = new ForkJoinPool();
    public static int findSum(int[] array){
        return fjPool.invoke(new SumTask(array, 0, array.length -1));
    }

    private static class SumTask extends RecursiveTask<Integer>{
        private final int[] array;
        private final int start, end;

        SumTask(int[] array, int start, int end){
            // array != null && start >= 0 && start <= end;

            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute(){
            //assert array != null && array.length > 0;
            //System.out.printf("sum( start=%d, end=%d )%n", start,end);

            if(end - start < 10000 ){
                int sum = 0;
                for (int i = start + 1; i <= end ; i++) {
                    sum += array[i];
                }
                return sum;
            }
            int middle = (start + end) /  2;
            SumTask leftTask = new SumTask(array, start, middle);
            leftTask.fork();

            SumTask rightTask = new SumTask(array, middle+1, end);
            int rightSum = rightTask.compute();
            int leftSum = leftTask.join();

            return rightSum + leftSum;
        }
    }
}
