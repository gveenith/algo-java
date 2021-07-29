import java.util.ArrayList;
import java.util.List;

public class TargetSumIK {

    public static void main(String[] args) {

        long[] arr = new long[] { 1 };
        List<Integer> result = new ArrayList<Integer>();
        check_if_sum_possible_helper(arr, 0, 0, result);
        System.out.print(result.contains(1));
    }

    static void check_if_sum_possible_helper(long[] arr, long target, int i, List<Integer> result) {

        // base
        if (i > 0 && target == 0) {
            result.add(1);
            return;
        }

        if (target < 0 || i >= arr.length) {
            // result.add(0);
            return;
        }

        check_if_sum_possible_helper(arr, target - arr[i], i + 1, result);
        check_if_sum_possible_helper(arr, target, i + 1, result);

    }

}
