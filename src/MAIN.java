import java.util.Random;

public class MAIN{
    public static void main(String[] args) throws Exception{
        int[] data = initalizeArray();
        int length = data.length;
        int half = length/2;
        int max;

        MyThread t1 = new MyThread(data, 0,half);
        MyThread t2 = new MyThread(data, half, length);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        max = Math.max(t1.getResult(), t2.getResult());

        System.out.println("Maxwert ist: " +max);
        System.out.println(Runtime.getRuntime().availableProcessors()); //Anzahl Kerne
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

