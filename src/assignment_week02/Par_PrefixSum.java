package assignment_week02;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Par_PrefixSum {
    private static final ForkJoinPool fjPool = new ForkJoinPool();


    public static int[] getPrefixSum(int[] array){
        return fjPool.invoke(new PrefixSumTask(array, 0, array.length));
    }

    private static class PrefixSumTask extends RecursiveTask<int[]> {
        private final int[] array;
        private final int start,end;

        public PrefixSumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected int[] compute(){
            if(problemIsSmallEnough()){
                int[] arrayCopy = new int[array.length];
                arrayCopy[0] = array[0];
                for (int i = 1; i < array.length; i++) {
                    arrayCopy[i] = array[i] + arrayCopy[i - 1];
                }
                return arrayCopy;
            }
            int middle = (start + end)  / 2;

            /*PrefixSumTask rightTask = new PrefixSumTask(array, middle , end);
            rightTask.fork();

            PrefixSumTask leftTask = new PrefixSumTask(array, start, middle);

            int[] leftArray = leftTask.compute();
            int[] rightArray = rightTask.join();*/

            PrefixSumTask leftTask = new PrefixSumTask(array, start, middle);
            leftTask.fork();
            PrefixSumTask rightTask = new PrefixSumTask(array, middle +1, end);
            int[] rightArray = rightTask.compute();
            int[] leftArray = leftTask.join();

            int[] combinedArray = new int[leftArray.length + rightArray.length];
            int rightArrayCounter = 0;
            int leftArrayEndNumber = leftArray.length-1;
            for (int i = 0; i < combinedArray.length; i++) {
                if(i < leftArray.length) {
                    combinedArray[i] = leftArray[i];
                }
                if (i >= leftArray.length){
                    combinedArray[i] = rightArray[rightArrayCounter] + leftArrayEndNumber;
                    rightArrayCounter++;
                }
            }
            return combinedArray;
        }

        private boolean problemIsSmallEnough(){
            return end - start < 10000;
        }
    }
}
