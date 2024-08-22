package solutions.kyu6.areWeAlternate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static boolean isAlt(String word) {
        Pattern pattern = Pattern.compile("[aeiou]{2}|[^aeiou]{2}");
        Matcher matcher = pattern.matcher(word);
        return !matcher.find();
    }

}
