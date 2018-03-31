package ex_05;

import java.util.Random;

public class Sequential_Sum {
    public static void main(String[] args) {
        final int N = 1000;
        int[] array = initalizeArray(N);
        int sum = 0;

        sum = sum(array);

        System.out.println(sum);
    }

    public static int sum(int[] data){
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }


    public static int[] initalizeArray(int N) {
        Random r = new Random();
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10);
        }
        return array;
    }

}