import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubsetIk {

    public static void main(String[] args) throws IOException {

        // List<String> sample = new ArrayList<String>();
        // sample.add("xy");
        // sample.add("x");
        // sample.add("y");
        // sample.add(" ");

        // String[] result;
        String s = "xy";
        List<String> result = new ArrayList<>();
        // System.out.println(s.toCharArray());
        generate_all_subsets_helper(s.toCharArray(), 0, result, new StringBuilder());
        String[] solution = new String[result.size() + 1];
        solution[0] = String.valueOf(result.size());
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).isEmpty()) {
                solution[i + 1] = "Empty";

            } else {
                solution[i + 1] = result.get(i);
            }

        }
        System.out.println(Arrays.toString(solution));
        // result.forEach(System.out::println);
        // result = generate_all_subsets(s);
        // for (int res_i = 0; res_i < result.length; res_i++) {
        // System.out.println(String.valueOf(result[res_i]));
        // }
    }

    /*
     * Complete the function below.
     */
    // static String[] generate_all_subsets(String s) {
    // List<String> result = new ArrayList<>();
    // char[] input = s.toCharArray();
    // System.out.println(input);
    // generate_all_subsets_helper(input, 0, result, new StringBuilder());
    // result.forEach(System.out::println);
    // String[] subset = new String[result.size()];
    // for (int i = 0; i < result.size(); i++) {
    // subset[i] = result.get(i);
    // }
    // return subset;

    // }

    static void generate_all_subsets_helper(char[] input, int i, List<String> result, StringBuilder sb) {

        if (i == input.length) {
            result.add(new String(sb));
            return;
        }

        sb.append(Character.toString(input[i]));
        generate_all_subsets_helper(input, i + 1, result, sb);
        sb.setLength(sb.length() - 1);
        generate_all_subsets_helper(input, i + 1, result, sb);
    }

}
