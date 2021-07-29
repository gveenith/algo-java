public class MergeKSortedArrays {
    // sol 1 - Min heap & heap sort : pop elements from array one by one and create
    // a heap (complete binary tree).
    // Delete min element from root and heapify , repeat the process (heap sort)
    // till entire array is sorted.
    // The issue here is since repeat is allowed (structural integrity cannot be
    // gauranteed).
    // Extra space is needed to store the heapified array.
    // time complexity - knlogkn
    // space complexity is not O(1) rather O(kn) as the heap array needs to be
    // built.
    // This gives room for a different approach.

    // quick sort is not an option as the arrays are alreay sorted and its gonna
    // screw up the time complexity

    // Sol 2 - Merge Sort : This leaves us with merge sort as we can achieve the
    // same TC as heap sort O(nklognk)
    // and also retain the structural integrity of array .
    // anyways we needed auxillary space in our sol 1 and we shouldnt be performing
    // bad here too .
    // space complexity - O(kn) -----> ????
    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 0, 9, 10, 11 } };
        int[] result = new int[12];
        // EC-1 - if array is empty
        if (arr.length == 0)
            return;
        result = mergeArraysHelper(arr, 0, arr.length - 1);
        for (int resItr = 0; resItr < result.length; resItr++) {
            System.out.println(String.valueOf(result[resItr]));

        }
    }

    // since these are sorted array and we know the size of each array (K) which is
    // same.
    // we can take 2 arrays and start compare and merge and form an array.
    // repeat this and make sure we have compared and merged (N) arrays.
    // this should leave is with a single sorted array.
    public static int[] mergeArraysHelper(int[][] arr, int start, int end) {
        // base case
        if (start >= end) {
            return arr[start];
        }
        // rec
        int mid = start + (end - start) / 2;
        int[] a = mergeArraysHelper(arr, start, mid);
        int[] b = mergeArraysHelper(arr, mid + 1, end);
        return compareAndMerge(a, b);

    }

    // compare the each item in 2 arrays and merge them to a res array .
    public static int[] compareAndMerge(int[] a, int[] b) {

        int i = 0;
        int j = 0;
        int k = 0;

        int[] res = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            res[k] = b[j];
            j++;
            k++;
        }

        return res;

    }

}
