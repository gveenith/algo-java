import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[] { 22, 60, 3, 20, 1 };
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));
        System.out.print("*---------");
        sort(array, array.length);
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));

    }

    public static void sort(int[] array, int length) {

        if (length < 2) {
            return;
        }

        int midPoint = length / 2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[length - midPoint];

        for (int i = 0; i < midPoint; i++) {
            leftArray[i] = array[i];
        }

        Arrays.stream(leftArray).forEach(System.out::print);
        System.out.print("*---------");

        for (int j = midPoint; j < length; j++) {
            rightArray[j - midPoint] = array[j];
        }

        Arrays.stream(rightArray).forEach(System.out::print);
        System.out.print("*---------");

        sort(leftArray, midPoint);
        sort(rightArray, length - midPoint);
        merge(array, leftArray, rightArray, midPoint, length - midPoint);
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray, int leftLength, int rightLength) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }

}
