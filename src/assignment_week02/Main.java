package assignment_week02;


import ex_05.Sequential_Sum;

public class Main {
    public static void main(String[] args){
        int array[] = {5,7,8,1};
        int array2[] = Sequential_Sum.initalizeArray(40000);
        System.out.print("\nArray:");
        System.out.println(array2[array2.length-1]);

        /*for (int i : array ){
            System.out.print("[" + i + "]");
        }*/

        Seq_PrefixSum sq = new Seq_PrefixSum(array2, 0 , array.length - 1);
        int[] arrayDone = sq.getPrefixSum();
        System.out.print("\nSequentiell:");
        System.out.println(arrayDone[0]);
        System.out.println(arrayDone[arrayDone.length-1]);
        /*for (int i : arrayDone) {
            System.out.print("[" + i + "]");
        }*/
        /*
        System.out.print("\nArray:");
        for (int i : array ){
            System.out.print("[" + i + "]");
        }*/

        int[] arrayDone2 = Par_PrefixSum.getPrefixSum(array2);
        System.out.print("\nParallel:");
        System.out.println(arrayDone2[0]);
        System.out.println(arrayDone2[arrayDone2.length-1]);
        /*for (int i : arrayDone2) {
            System.out.print("[" + i + "]");
        }*/

        int diff = arrayDone2[arrayDone2.length-1] - arrayDone[arrayDone.length-1];
        System.out.println("\nDiff:"+diff);

    }
}
