import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[] { 22, 60, 3, 20, 1 };
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));
        System.out.print("*---------");
        sort(array, 0, array.length - 1);
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));

    }

    public static void sort(int[] array, int start, int end) {
        if (start < end) {
            int pIndex = partition(array, start, end);
            sort(array, start, pIndex - 1);
            sort(array, pIndex + 1, end);
        }

    }

    public static int partition(int[] array, int start, int end) {
        randomPartition(array, start, end);
        int pivot = end;

        int pIndex = start;
        for (int i = start; i <= end - 1; i++) {
            if (array[i] <= array[pivot]) {
                swap(array, i, pIndex);
                pIndex++;
            }
        }

        swap(array, pIndex, pivot);
        return pIndex;
    }

    public static void randomPartition(int[] array, int start, int end) {
        int pivot = new Random().nextInt(end - start) + start;
        swap(array, pivot, end);
    }

    public static void swap(int[] array, int i, int pIndex) {
        int temp = array[i];
        array[i] = array[pIndex];
        array[pIndex] = temp;

    }

}
