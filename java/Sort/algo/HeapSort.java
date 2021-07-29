import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int ex = 7 / 2 - 1;
        System.out.println(ex);

        int[] array = new int[] { 10, 20, 15, 12, 40, 25, 18 };
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));
        System.out.print("*---------");
        sort(array);
        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));
    }

    public static void sort(int[] array) {
        int length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        Arrays.stream(array).forEach((item) -> System.out.print(item + ","));
        System.out.print("*---------");
        System.out.println("sort");
        for (int j = length - 1; j >= 0; j--) {
            swap(array, j, 0);
            heapify(array, j, 0);
        }

    }

    public static void heapify(int[] array, int length, int index) {
        int parent = index;
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;

        System.out.println("leftChild " + leftChild);
        System.out.println("rightChild" + rightChild);

        if (leftChild < length && array[leftChild] > array[parent]) {
            parent = leftChild;
        }
        if (rightChild < length && array[rightChild] > array[parent]) {
            parent = rightChild;
        }

        if (parent != index) {
            swap(array, index, parent);
            heapify(array, length, parent);
        }

    }

    public static void swap(int[] array, int index, int parent) {
        int temp = array[index];
        array[index] = array[parent];
        array[parent] = temp;
    }

}
