package solutions.kyu6.consonant_value;

import java.util.Arrays;

public class ConsonantValue {

    public static int solve(String s) {
        return Arrays.stream(s.split("[aeiou]"))
                .mapToInt(ConsonantValue::value)
                .max()
                .orElseThrow();

    }

    private static int value(String s) {
        final int offset = 'a' - 1;
        return s.chars()
                .map(c -> c - offset)
                .sum();
    }
}
