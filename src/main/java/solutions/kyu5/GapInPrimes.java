package solutions.kyu5;

public class GapInPrimes {

    public static long[] gap(int gap,
                             long start,
                             long end) {
        if (gap < 2) {
            throw new IllegalArgumentException("Wrong input. Gap must be greater than or equal to 2");
        }
        if (start <= 2) {
            throw new IllegalArgumentException("Wrong input. Start number must be greater than 2");
        }
        if (end < start) {
            throw new IllegalArgumentException("Wrong input. End number must be greater or equal to start number");
        }

        return null;
    }

    public static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        if (number % 2 == 0) {
            return number == 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
