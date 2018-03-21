package ex_05;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorService_Sum {
    public static void main(String[] args) throws Exception {
        int N = 100000000;
        int P = 100;
        int piece = N / P;
        int[] data = Sequential_Sum.initalizeArray(N);
        ExecutorService exes = Executors.newFixedThreadPool(4);
        List<Future> futures = new LinkedList<Future>();

        for (int i = 0; i < P; i++) {
            int start = i * piece;
            int end = ((i + 1) * piece) - 1;
             MaxWorker r = new MaxWorker(data, start, end);
             Future<Integer> f = exes.submit(r);
             futures.add(f);
        }
        Integer result = 0;
        for (Future<Integer> f : futures) {
            result += f.get();
        }
        System.out.println(result);
        exes.shutdown();
    }
}
