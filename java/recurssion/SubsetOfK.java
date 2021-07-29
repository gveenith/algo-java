import java.util.ArrayList;
import java.util.List;

public class SubsetOfK {

    // int k = 3;
    public static void main(String[] args) {

        int[] input = { 2, 3, 6, 7 };
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        subsetHelper(input, 0, 7, result, tempResult);
        result.forEach(System.out::println);
    }

    public static void subsetHelper(int[] input, int i, int k, List<List<Integer>> result, List<Integer> tempResult) {

        // tempResult.forEach(System.out::println);
        // System.out.println("----" + k);
        if (k == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
        if ((i >= input.length) || (k < 0)) {
            return;
        }

        tempResult.add(input[i]);
        k = k - input[i];
        subsetHelper(input, i, k, result, tempResult);
        tempResult.remove(tempResult.size() - 1);
        k = k + input[i];
        // System.out.println("here");
        subsetHelper(input, i + 1, k, result, tempResult);
    }

}
