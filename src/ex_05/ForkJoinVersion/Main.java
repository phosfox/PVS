package ex_05.ForkJoinVersion;

import ex_05.MaxWorker;
import ex_05.Sequential_Sum;

public class Main {
    public static void main(String[] args){
        int[] array = {1,1,1,1,1,1,1,1};
        int[] array2 = Sequential_Sum.initalizeArray(2000);

        System.out.println(ForkJoinWorker.findSum(array));
        System.out.println(ForkJoinWorker.findSum(array2));
    }
}
