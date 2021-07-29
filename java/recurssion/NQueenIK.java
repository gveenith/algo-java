import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenIK {

    public static void main(String[] args) {
        int n = 4;
        List<String[]> finalResult = new ArrayList<String[]>();
        find_all_arrangements_helper(n, 0, new int[n], finalResult);
        System.out.println(finalResult.toArray(new String[0][n]));
    }

    public static void find_all_arrangements_helper(int n, int i, int[] result, List<String[]> finalResult) {

        if (n == i) {
            finalResult.add(getArrangement(result));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isQueenSafe(i, j, result)) {
                result[i] = j;
                find_all_arrangements_helper(n, i + 1, result, finalResult);
            }
        }

    }

    public static boolean isQueenSafe(int i, int j, int[] result) {
        for (int row = i - 1, rdiag = j + 1, ldiag = j - 1; row >= 0; row--, rdiag++, ldiag--) {
            if (result[row] == j || result[row] == rdiag || result[row] == ldiag) {
                return false;
            }
        }
        return true;
    }

    static String[] getArrangement(int[] positions) {
        String[] arrangement = new String[positions.length];
        char[] row = new char[positions.length];
        Arrays.fill(row, '-');
        for (int i = 0; i < positions.length; i++) {
            row[positions[i]] = 'q';
            arrangement[i] = new String(row);
            row[positions[i]] = '-';
        }
        return arrangement;
    }

}
