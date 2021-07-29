import java.util.ArrayList;
import java.util.List;

public class EnumerateBinaryStringDFS {

    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<String>();
        enumerateBinaryString(n, 0, result, new StringBuilder());
        result.forEach(System.out::println);
    }

    public static void enumerateBinaryString(int n, int i, List<String> result, StringBuilder sb) {

        if (n == i) {
            result.add(new String(sb.toString()));
        } else {

            enumerateBinaryString(n, i + 1, result, sb.append("0"));
            sb.setLength(sb.length() - 1);
            System.out.println("Start: " + sb.toString());
            enumerateBinaryString(n, i + 1, result, sb.append("1"));
            System.out.println("End:" + sb.toString());
        }
    }

}
