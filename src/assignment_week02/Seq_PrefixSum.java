package assignment_week02;

public class Seq_PrefixSum {
    private  int[] array;
    private int start, end;

    public Seq_PrefixSum(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int[] getPrefixSum(){
        int[] arrayCopy = new int[array.length];
        arrayCopy[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            arrayCopy[i] = array[i] + arrayCopy[i-1];
        }
        return arrayCopy;
    }
}
