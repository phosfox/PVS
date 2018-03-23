package ex_05;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinMain {
    public static void main(String[] args) {
        int array[] = Sequential_Sum.initalizeArray(2000);
        ForkJoinWorker fjw = new ForkJoinWorker(array,0,array.length -1); //vllt auch length -1
        ForkJoinPool.commonPool().invoke(fjw);
        int sum = fjw.ans;

        System.out.println("Summe: " +sum);
    }
}
