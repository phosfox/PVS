package ex_05;

public class Thread_Sum {
    public static void main(String[] args) throws Exception {
        final int N = 1000;
        int data[] = Sequential_Sum.initalizeArray(N);
        int length = data.length;
        int half = length / 2;
        int sum = 0;

        MyThreadSum t1 = new MyThreadSum(data, 0, half);
        MyThreadSum t2 = new MyThreadSum(data, half, length);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        sum = t1.getResult() + t2.getResult();
        System.out.println("Die Summe ist: " +sum);
    }

}
