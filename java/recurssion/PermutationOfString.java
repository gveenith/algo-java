import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

    public static void main(String[] args) {
        String input = "abc";
        List<String> result = new ArrayList<String>();
        permutationStringHelper(input.toCharArray(), 0, result);
        result.forEach(System.out::println);
    }

    public static void permutationStringHelper(char[] input, int i, List<String> result) {

        System.out.println(i + " " + new String(input));
        System.out.println("--------");
        if (i == input.length) {
            result.add(new String(input));
            return;
        }

        for (int j = i; j < input.length; j++) {
            System.out.println(i + " in for loop with j " + j + " " + new String(input));
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            permutationStringHelper(input, i + 1, result);
        }

    }

}
