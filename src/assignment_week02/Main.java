package assignment_week02;


import Timing.StopWatch;
import ex_05.Sequential_Sum;

import java.util.Random;
import java.util.function.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int array[] = {5,7,8,1};
        int array2[] = initArray(10);
        int[] array2Unchanged = array2;

        Arrays.stream(array2).forEach(e -> System.out.print("[" +e+ "]"));
        //System.out.print("\nArray :" +Arrays.toString(array2));
        System.out.println();
        System.out.println();


        Seq_PrefixSum sq = new Seq_PrefixSum(array, 0 , array.length - 1);
        long start = System.nanoTime();
        int[] arrayDone = sq.getPrefixSum();
        long stop = System.nanoTime();

        System.out.print("\nSequentiell Last Item:" + arrayDone[arrayDone.length - 1]);
        System.out.println();
        System.out.println(stop - start+ "ns");

        System.out.println();
        System.out.println();

        long start2 = System.nanoTime();
        Exec_PrefixSum exsum = new Exec_PrefixSum(array);
        long stop2 = System.nanoTime();
        exsum.printData();
        System.out.println();
        System.out.println(stop2 - start2 + "ns");

        System.out.println();
        System.out.println();
        System.out.println("ParallelStream Prefix");

        IntBinaryOperator op = (x,y) -> x + y;
        Arrays.parallelPrefix(array2Unchanged, op);
        Arrays.stream(array2Unchanged).forEach(e -> System.out.print(e + " "));
    }

    static int[] initArray(int size){
        Random r = new Random();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = r.nextInt(2);
        }
        return ints;
    }
}
