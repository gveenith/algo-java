import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        String input = "a1b2";
        List<String> resultList = new ArrayList<String>();
        letterCasePermutationHelper(input.toCharArray(), 0, resultList);
        resultList.forEach(System.out::println);
    }

    public static void letterCasePermutationHelper(char[] input, int i, List<String> resultList) {
        // base case - add strings to result
        if (i == input.length) {
            resultList.add(new String(input));
        } else {
            if (Character.isLetter(input[i])) {
                input[i] = Character.toLowerCase(input[i]);
                letterCasePermutationHelper(input, i + 1, resultList);
                input[i] = Character.toUpperCase(input[i]);
                letterCasePermutationHelper(input, i + 1, resultList);
            } else {
                letterCasePermutationHelper(input, i + 1, resultList);
            }

        }
    }

}