package Timing;

public class StopWatch {
    private static long start;
    private static long stop;

    public static void start(){
        start = System.nanoTime();
    }

    public static void stop(){
        stop = System.nanoTime();
    }

    public static long getTime(){
        return stop - start;
    }
}
