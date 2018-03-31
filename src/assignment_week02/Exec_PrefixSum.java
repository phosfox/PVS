package assignment_week02;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Exec_PrefixSum {
    private int CPUCOUNT = Runtime.getRuntime().availableProcessors();
    private int N = 100000000,P = 10000000;
    private int piece = N / P;
    private int[] data;
    private ExecutorService exes = Executors.newFixedThreadPool(CPUCOUNT);
    private List<Future> futures = new LinkedList<Future>();

    public Exec_PrefixSum(int[] data) {
        this.data = data;
        submitWorkers();
        waitTillFuturesDone();
        addLastToFields();
        exes.shutdown();
    }
    public int[] getResult() throws ExecutionException, InterruptedException {
        for (Future<int[]> f : futures) {
            data = f.get();
        }
        return data;
    }

    private void submitWorkers(){
        for (int i = 0; i < piece; i++) {
            int start = i * piece;
            int end = ((i + 1) * piece) -1;
            Callable<int[]> peon = new PrefixWorker(data, start, end);
            futures.add(exes.submit(peon));
        }
    }

    private void waitTillFuturesDone(){
        for (Future f: futures) {
            while(!(f.isDone())) ;
        }
    }

    private void addLastToFields() {
        int EndIntOfPiece = data[piece - 1];
        for (int i = piece; i < this.data.length; i++) {
            data[i] += EndIntOfPiece;
        }
        /*for (int i = 1; i < piece; i++) {
            data[piece + 1] += data[(piece * i) -1];

        }*/
    }

    public int[] getData(){
        return this.data;
    }

    public void printData(){
        System.out.print("Executor Last Item:" + this.data[data.length - 1]);
    }
}
