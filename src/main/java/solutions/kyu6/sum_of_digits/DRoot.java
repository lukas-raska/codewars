package solutions.kyu6.sum_of_digits;


public class DRoot {

    public static void main(String[] args) {
        int number = 439705;
        System.out.println(digitalRoot(number));
        System.out.println(digitalRootRecursive(number));

    }

    public static int digitalRoot(int n) {
        int sum = sumDigits(n);
        while (sum >= 10) {
            sum = sumDigits(sum);
        }
        return sum;
    }

    public static int digitalRootRecursive(int n) {
        int sum = sumDigits(n);
        if (sum < 10) {
            return sum;
        }
        return digitalRootRecursive(sum);

    }


    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
