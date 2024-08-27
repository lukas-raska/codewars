package solutions.kyu7.DisemvowelTrolls;

import java.util.stream.Collectors;

public class Troll {

    public static String disemvowel(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
