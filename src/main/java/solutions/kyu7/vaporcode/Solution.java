package solutions.kyu7.vaporcode;

import java.util.stream.Collectors;

public class Solution {

    public static String vaporcode(String string) {

        return string
                .toUpperCase()
                .replaceAll("[ \\t]", "")
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining("  "));
    }
}
