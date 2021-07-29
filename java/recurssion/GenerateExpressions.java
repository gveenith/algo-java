import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateExpressions {

    public static void main(String[] args) {

        // String s = "222";
        // int[] input = new int[s.length()];

        // for (int i = 0; i < s.length(); i++) {
        // input[i] = Character.digit(s.charAt(i), 10);
        // }
        // int runningSum = 0;
        // List<String> result = new ArrayList<>();
        // for (int j = 0; j < s.length(); j++) {
        // String inputState = s.substring(j , s.length());
        int[] input = new int[] { 2, 2, 2 };
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // loop for join
        for (int j = 0; j < s.length(); j++) {
            sb.append(String.valueOf(input[j]));
            // figure out j
            generateExpressionsHelper(input, 10, 1, 2, result, sb);
        }

        // result.forEach(System.out::println);
        // }

    }

    public static void generateExpressionsHelper(int[] input, int target, int i, int runningSum, List<String> result,
            StringBuilder sb) {

        if (i == input.length && runningSum == target) {
            result.add(sb.toString());
            return;
        }

        if (i >= input.length || runningSum > target) {
            return;
        }
        // *
        sb.append("*" + String.valueOf(input[i]));
        generateExpressionsHelper(input, target, i + 1, runningSum * input[i], result, sb);
        // +
        sb.setLength(sb.length() - 2);
        sb.append("+" + String.valueOf(input[i]));
        generateExpressionsHelper(input, target, i + 1, runningSum + input[i], result, sb);
        sb.setLength(sb.length() - 2);
    }
}
