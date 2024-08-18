package solutions.kyu5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class GapInPrimes {

    public static long[] findPrimeGap(int gap,
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

        List<Long> primes = new LinkedList<>();

        for (long i = start; i <= end; i++) {

            if (isPrime(i)) {
                primes.add(i);
            }

            if (primes.size() == 2) {
                if (primes.getLast() - primes.getFirst() == gap) {
                    return new long[]{primes.getFirst(), primes.getLast()};
                } else {
                    primes.removeFirst();
                }
            }
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
