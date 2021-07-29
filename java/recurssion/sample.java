import java.util.Arrays;

;

public class sample {

    public static void main(String[] args) {
        int[] num = { 1, 2, 2 };
        Arrays.stream(num).forEach(System.out::println);
    }

}
