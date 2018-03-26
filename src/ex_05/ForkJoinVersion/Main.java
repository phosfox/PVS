package ex_05.ForkJoinVersion;
import Timing.StopWatch;
import ex_05.MaxWorker;
import ex_05.ParallelStream_Sum;
import ex_05.Sequential_Sum;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StopWatch sw = new StopWatch();
        System.out.print("Arraygröße:");
        int number = sc.nextInt();

        int[] array2 = Sequential_Sum.initalizeArray(number);

        long time1 = System.nanoTime();
        System.out.println(Sequential_Sum.sum(array2));
        long time2 = System.nanoTime();
        System.out.println("Sequentiell: Difference: " + (time2 - time1) + "ns");

        long time3 = System.nanoTime();
        System.out.println(ForkJoinWorker.findSum(array2));
        long time4 = System.nanoTime();
        System.out.println("ForkJoin: Difference: " + (time4 - time3) + "ns");

        sw.start();
        System.out.println(ForkJoinWorker.findSum(array2));
        sw.stop();
        System.out.println("ForkJoin: Difference: " + sw.getTime() + "ns");

        long time5 = System.nanoTime();
        System.out.println(Arrays.stream(array2).parallel().reduce(0,(a, b) -> a+b));
        long time6 = System.nanoTime();
        System.out.println("ParallelStream: Difference: " + (time6 - time5) + "ns");


        }
    }

