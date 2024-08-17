package solutions.kyu8.WilsonPrimes;

import java.math.BigDecimal;

public class WilsonPrime {

    public static void main(String[] args) {




    }

    private static BigDecimal factorial(long number) {
        if (number < 0) {
            throw new ArithmeticException(number + " is not a natural number. Factorial is not defined.");
        }
        if (number == 0) {
            return BigDecimal.ONE;
        }
        return BigDecimal
                .valueOf(number)
                .multiply(factorial(number - 1));
    }
}
