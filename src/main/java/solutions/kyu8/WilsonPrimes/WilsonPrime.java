package solutions.kyu8.WilsonPrimes;

import java.math.BigInteger;

public class WilsonPrime {

    public static void main(String[] args) {

        System.out.println(amIWilson(563));
        System.out.println(amIWilson(13));
        System.out.println(amIWilson(5));


    }

    /**
     * Determines whether the specified number is a wilson prime number
     * Uses Wilson´s theorem (<a href="https://en.wikipedia.org/wiki/Wilson_prime">...</a>)
     * @param n - natural number
     * @return - return true, if given natural number is a Wilson prime
     */
    private static boolean amIWilson(long n) {
        if (n < 2) {
            return false;
        }
        //
        BigInteger reader = factorial(n - 1).add(BigInteger.ONE);
        BigInteger denominator = BigInteger.valueOf(n).pow(2);

        return reader.mod(denominator).equals(BigInteger.ZERO);
    }

    /**
     * Determines the factorial of given natural number
     * @param number Natural number
     * @return Factorial of natural number
     */
    private static BigInteger factorial(long number) {
        if (number < 0) {
            throw new ArithmeticException(number + " is not a natural number. Factorial is not defined.");
        }
        if (number == 0) {
            return BigInteger.ONE;
        }
        return BigInteger
                .valueOf(number)
                .multiply(factorial(number - 1));
    }


}
