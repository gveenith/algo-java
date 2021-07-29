import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaPractice {
    public static void main(String[] args) {
        Integer[] input = new Integer[] { 1, 4, 6, 3, 7, 10 };
        List<Integer> numbers = Arrays.asList(input);
        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);
        int sum2 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2);
        int sum3 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum3);
        int sum4 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum4);

        Supplier

    }
}
