package probs;

import java.util.Arrays;

public class MergeOneToAnother {

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3 };
        int[] arr2 = new int[] { 4, 5, 6, 0, 0, 0 };

        int largeArray = (arr2.length / 2) - 1;
        int smallArray = arr1.length - 1;
        int largeArrayEnd = arr2.length - 1;

        while (largeArray >= 0 && smallArray >= 0) {
            arr2[largeArrayEnd--] = (arr1[smallArray] > arr2[largeArray]) ? arr1[smallArray--] : arr2[largeArray--];
        }

        while (smallArray >= 0) {
            arr2[largeArrayEnd--] = arr1[smallArray--];
        }

        Arrays.stream(arr2).forEach(System.out::println);

    }

}
