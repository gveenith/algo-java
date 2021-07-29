import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[] { 22, 60, 3, 20, 1 };
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("--------");
        compareAndSort(array);
        Arrays.stream(array).forEach(System.out::println);

    }

    public static void compareAndSort(int[] array) {
        // outer loop to pick an item from left to right
        for (int i = 0; i <= array.length - 2; i++) {
            // set min as i
            int min = i;

            // inner loop to iterate i+1 till end and find the smallest item
            for (int j = i + 1; j <= array.length - 1; j++) {
                // compare min and j and and if j is smaller then swap j with min
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    public static void swap(int[] array, int i, int min) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }

}
