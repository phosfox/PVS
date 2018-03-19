public class MyThread extends Thread {
    private int[] data;
    private int start;
    private int end;
    private int result;

    MyThread(int[] data, int start, int end){
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public void run(){
        this.result = max(data, start, end);
    }

    public int getResult(){
        return this.result;
    }

    public int max(int data[], int start, int end){
        int max = Integer.MIN_VALUE;

        for(int i = start; i<end; i++){
            max = Math.max(max, data[i]);
        }
        return max;
    }
}
