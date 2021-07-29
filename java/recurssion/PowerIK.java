public class PowerIK {

    public static long MOD = 1000000007;

    public static void main(String[] args) {
        long a = 2;
        long b = 10;
        int value = calculate_power_helper(a, b);
        System.out.println(value);

    }

    public static int calculate_power_helper(long base, long exponent) {

        if (exponent == 0) {
            return 1;
        }

        base = base % MOD;
        long value = calculate_power_helper(base, exponent / 2);

        value = value * value;

        if (exponent % 2 == 1) {
            value = value * base % MOD;
        }

        return (int) value;

    }
}
