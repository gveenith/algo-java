import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class WellFormedBrackets {
    public static void main(String[] args) {
        int n = 2;
        List<List<String>> result = new ArrayList<>();
        WellFormedBracketsHelper(n, result, 0, 0, 0, new ArrayList<String>());
        result.forEach(System.out::println);
    }

    public static void WellFormedBracketsHelper(int n, List<List<String>> result, int open, int close, int i,
            List<String> tempResult) {
        if (open >= close && close >= open && n > 0) {
            result.add(new ArrayList(tempResult));
            return;
        }

        if (open < n) {
            tempResult.add("(");
            WellFormedBracketsHelper(n, result, open + 1, close, i + 1, tempResult);
        }

        if (close < open) {
            tempResult.add(")");
            WellFormedBracketsHelper(n, result, open, close + 1, i + 1, tempResult);
        }
    }

}
