package assignment_week02;


import Timing.StopWatch;
import ex_05.Sequential_Sum;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int array[] = {5,7,8,1};
        int array2[] = Sequential_Sum.initalizeArray(100000000);
        //System.out.print("\nArray :" +Arrays.toString(array2));
        System.out.println();
        System.out.println();


        Seq_PrefixSum sq = new Seq_PrefixSum(array2, 0 , array.length - 1);
        long start = System.nanoTime();
        int[] arrayDone = sq.getPrefixSum();
        long stop = System.nanoTime();

        System.out.print("\nSequentiell Last Item:" + arrayDone[arrayDone.length - 1]);
        System.out.println();
        System.out.println(stop - start+ "ns");

        System.out.println();
        System.out.println();

        long start2 = System.nanoTime();
        Exec_PrefixSum exsum = new Exec_PrefixSum(array2);
        long stop2 = System.nanoTime();
        exsum.printData();
        System.out.println();
        System.out.println(stop2 - start2 + "ns");



    }
}
