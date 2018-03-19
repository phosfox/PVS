package ex_05;

public class MyThreadSum extends Thread {
    private int[] data;
    private int start;
    private int end;
    private int result;

    public MyThreadSum(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public void run(){
        this.result = sum(data, start, end);
    }

    public int getResult(){
        return this.result;
    }

    public int sum(int data[], int start, int end){
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += data[i];
        }

        return sum;
    }
}
