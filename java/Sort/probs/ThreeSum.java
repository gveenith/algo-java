package probs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    /*
     * Complete the function below.
     */

    // sol 1 : sort the array
    // have a current pointer pointer . left pointer (current + 1) and right
    // pointer.
    // sum curr + left +right and if its more than 0 then reduce right
    // if its less than sum then increase left pointer
    // try this till they dont cross .
    // if there is a match store the result .
    // if not then increase current and repreat the process

    // sol 2 : find subset whose sum is 0 and length is 3 using DFS
    public static void main(String[] args) {
        int[] arr = new int[] { 0, 3, -4, 1, -6, 6 };
        Set<List<String>> result = new HashSet<>();
        findZeroSumHelper(arr, 0, 0, result, new ArrayList<String>());
        String[] res = new String[result.size()];
        print(result, res);
        System.out.println(Arrays.toString(res));

    }

    static void findZeroSumHelper(int[] arr, int i, int sum, Set<List<String>> result, List<String> tempResult) {
        // prune
        if (sum == 0 && tempResult.size() == 3) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
        // base
        if (i >= arr.length) {
            return;
        }

        // rec
        sum = sum + arr[i];
        tempResult.add(String.valueOf(arr[i]));
        findZeroSumHelper(arr, i + 1, sum, result, tempResult);
        sum = sum - arr[i];
        tempResult.remove(tempResult.size() - 1);
        findZeroSumHelper(arr, i + 1, sum, result, tempResult);

    }

    static void print(Set<List<String>> result, String[] res) {
        int i = 0;
        for (List<String> printArray : result) {
            System.out.println(printArray);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < printArray.size(); j++) {

                sb.append(printArray.get(j));
                if (j != printArray.size() - 1)
                    sb.append(",");
            }

            res[i] = sb.toString();
            i++;
        }
    }

}
