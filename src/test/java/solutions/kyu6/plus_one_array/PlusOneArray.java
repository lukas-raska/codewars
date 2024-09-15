package solutions.kyu6.plus_one_array;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PlusOneArray {

    public static int[] upArray(final int[] digits) {

        if (digits == null || hasNegativeElements(digits) || hasMultiDigitElements(digits) || digits.length == 0) {
            return null;
        }

        String digitsString = Arrays.stream(digits)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        BigInteger number = new BigInteger(digitsString);

        return number.add(BigInteger.ONE).toString()
                .chars()
                .map(Character::getNumericValue)
                .toArray();

    }

    private static boolean hasNegativeElements(int[] numbers) {
        long countOfNegative = Arrays.stream(numbers).filter(n -> n < 0).count();
        return countOfNegative > 0;
    }

    private static boolean hasMultiDigitElements(int[] numbers) {
        long countOfMultiDigit = Arrays.stream(numbers).filter(n -> n > 9).count();
        return countOfMultiDigit > 0;
    }
}
