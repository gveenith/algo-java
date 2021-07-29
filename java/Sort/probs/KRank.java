import java.util.Arrays;
import java.util.Random;

public class KRank {
    public static void main(String[] args) {
        int[] input = new int[] { 22, 77, 33, 55, 99, 44 };
        int k = 3;
        int result = kRankHelper(input, 0, input.length - 1, k);
        System.out.println(result);
        Arrays.stream(input).forEach(System.out::print);
    }

    public static int kRankHelper(int[] input, int start, int end, int k) {

        // sort the list and for the given position return the number . this would take
        // qs nlogn and n2 in worst .
        // where as if i sort till i find just k then i can save time .
        // partition
        // find where k lies and trigger that side of sort.

        int pIndex = partition(input, start, end);

        // quick select
        if (pIndex == k - 1) {
            return input[pIndex];
        }

        if (pIndex < k) {
            return kRankHelper(input, start, pIndex - 1, k);
        }
        return kRankHelper(input, pIndex + 1, end, k);

    }

    public static int partition(int[] input, int start, int end) {
        int pivot = end;
        int j = start;
        for (int i = start; i <= end - 1; i++) {
            // compare each element with pivot
            if (input[i] <= input[pivot]) {
                swap(input, i, j);
                j++;
            }
        }
        // swap pivot position
        swap(input, j, pivot);
        return j;
    }

    // public static void pivot(int[] input, int start, int end) {
    // int randomPivot = new Random().nextInt(end - start) + start;
    // swap(input, randomPivot, end);
    // }

    public static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}