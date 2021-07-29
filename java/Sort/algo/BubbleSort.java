import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[] { 22, 60, 3, 20, 1 };
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));
        System.out.print("*---------");
        CompareAndSwap(array);
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));

    }

    public static void CompareAndSwap(int[] array) {

        // outer loop from start to end
        for (int i = 0; i <= array.length - 1; i++) {
            // inner loop from start to end minus 1 item as we will any ways include that in
            // comparison (j+1)
            // compare and swap
            for (int j = 0; j <= array.length - 2; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int j, int max) {
        int temp = array[j];
        array[j] = array[max];
        array[max] = temp;
    }

}
