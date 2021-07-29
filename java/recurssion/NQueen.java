public class NQueen {

    public static void main(String[] args) {
        int input = 4;
        int[] result = new int[input];
        nQueenHelper(input, 0, result);
    }

    public static void nQueenHelper(int input, int i, int[] result) {

        if (i == input) {
            print(input, result);
            return;
        }

        for (int j = 0; j < input; j++) {
            
            if (isQueenSafe(result, i, j)) {
                result[i] = j;
                nQueenHelper(input, i + 1, result);
            }
        }

    }

    public static boolean isQueenSafe(int[] result, int i, int j) {

        for (int row = i - 1, ldiag = j - 1, rdiag = j + 1; row >= 0; row--, ldiag--, rdiag++) {
            if (result[row] == j || result[row] == ldiag || result[row] == rdiag) {
                return false;
            }
        }

        return true;

    }

    public static void print(int input, int[] result) {
        System.out.println("*************");
        for (int k = 0; k < input; k++) {
            System.out.println(k + " " + result[k]);
        }
    }
}
