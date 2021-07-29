import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsets {

    public static void main(String[] args) {

        int[] input = { 1, 2, 3 };
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<Integer>();
        subsetHelper(input, 0, result, tempResult);
        result.forEach(System.out::println);
    }

    public static void subsetHelper(int[] input, int i, List<List<Integer>> result, List<Integer> tempResult) {
        if (i == input.length) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        tempResult.add(input[i]);
        // include 0
        subsetHelper(input, i + 1, result, tempResult);
        // exclude 0
        tempResult.remove(tempResult.size() - 1);
        subsetHelper(input, i + 1, result, tempResult);

    }
}
