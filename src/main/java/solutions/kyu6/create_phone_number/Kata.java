package solutions.kyu6.create_phone_number;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {

    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length != 10) {
            throw new IllegalArgumentException("Wrong length of input: " + numbers.length);
        }
        return "(%d%d%d) %d%d%d-%d%d%d%d".formatted(Arrays.stream(numbers).boxed().toArray());
    }
}
