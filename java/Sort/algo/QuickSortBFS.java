import java.util.Arrays;

public class QuickSortBFS {

    public static void main(String[] args) {

        int[] array = new int[] { 22, 60, 3, 20, 1 };
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));
        System.out.print("*---------");
        quicksort(0, array.length - 1, array);
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));

    }

    public static void quicksort(int left, int right, int[] numberArray) {
        if (left >= right) {
            return;
        }
        int pivot = numberArray[(left + right) / 2];
        int index = partition(right, left, numberArray, pivot);
        quicksort(right, index - 1, numberArray);
        quicksort(index + 1, left, numberArray);
    }

    public static int partition(int right, int left, int[] numberArray, int pivot) {
        // Right Check
        // while low and high hasnt crossed over
        while (left <= right) {
            // if low is greater than pivot
            while (numberArray[right] > pivot) {
                // return the position
                right--;
            }
            while (numberArray[left] < pivot) {
                left++;
            }
        }
        if (left <= right) {
            swap(right, left, numberArray);
            left++;
            right--;
        }
        return left;
    }

    public static void swap(int i, int pIndex, int[] array) {
        int temp = array[i];
        array[i] = array[pIndex];
        array[pIndex] = temp;

    }

}
