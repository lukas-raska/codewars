package solutions.kyu6.consecutive_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestConsec {

    public static String longestConsec(String[] strarr,
                                       int k) {

        if (k <= 0 || k > strarr.length) {
            return "";
        }

        List<String> composedStrings = new ArrayList<>();

        for (int i = 0; i <= strarr.length - k; i++) {

            composedStrings.add(String.join(
                    "",
                    Arrays.copyOfRange(strarr, i, i + k)
            ));
        }

        var maxLength = composedStrings.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow();

        return composedStrings.stream()
                .filter(s -> s.length() == maxLength)
                .findFirst()
                .orElseThrow();
    }
}
