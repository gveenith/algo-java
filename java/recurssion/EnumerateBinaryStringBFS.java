import java.util.ArrayList;
import java.util.List;

public class EnumerateBinaryStringBFS {

    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<String>();
        binaryStringHelper(n, result);
    }

    public static void binaryStringHelper(int n, List<String> result) {

        if (n == 1) {
            System.out.println("index " + n);
            result.add("0");
            result.add("1");
        } else {
            binaryStringHelper(n - 1, result);
            System.out.println("index " + n);
            List<String> tempResult = new ArrayList<String>();
            for (String item : result) {
                tempResult.add(item + "0");
                tempResult.add(item + "1");
            }
            result.addAll(tempResult);
            result.forEach(System.out::println);
        }

    }

}