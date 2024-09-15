package solutions.kyu6.plus_one_array.solutionV2;

import java.util.Arrays;

public class PlusOneArray {

    public static int[] upArray(final int[] digits) {

        if (!isValid(digits)) {
            return null;
        }
        int length = digits.length;
        int[] result = Arrays.copyOf(digits, length);

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                result[i]++;
                return result;
            }
            result[i] = 0;
        }
        result = new int[length + 1];
        result[0] = 1;
        return result;
    }

    private static boolean isValid(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return Arrays.stream(array).allMatch(i -> i >= 0 && i < 10);
    }
}
