package solutions.kyu5;

import java.util.ArrayList;
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
        List<Long> primes = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
            if (primes.size() == 2) {
                if (primes.get(1) - primes.get(0) == gap) {
                    return primes.stream()
                            .mapToLong(Long::longValue)
                            .toArray();
                } else {
                    primes.set(0,primes.get(1));
                    primes.remove(1);
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
        if (number % 3 == 0) {
            return number == 3;
        }
        for (int i = 5; i <= Math.sqrt(number); i += 6) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
