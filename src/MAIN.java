import Timing.StopWatch;

import java.util.Random;
import Timing.StopWatch;

public class MAIN{
    public static void main(String[] args) throws Exception{
        int[] data = initalizeArray();
        int length = data.length;
        int half = length/2;
        int max;
        StopWatch sw = new StopWatch();
        MyThread t1 = new MyThread(data, 0,half);
        MyThread t2 = new MyThread(data, half, length);
        sw.start();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        max = Math.max(t1.getResult(), t2.getResult());

        System.out.println("Maxwert ist: " +max);
        System.out.println(Runtime.getRuntime().availableProcessors()); //Anzahl Kerne
        sw.stop();
        System.out.println("Time in : " + sw.getTime() + "ns");
    }

    static int[] initalizeArray(){
        Random r = new Random();
        int[] array = new int[200];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(20000);
        }
        return array;
    }
}

