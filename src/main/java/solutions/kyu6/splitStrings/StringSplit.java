package solutions.kyu6.splitStrings;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class StringSplit {

    public static String[] solution(String s) {

        if (s.length() % 2 != 0) {
            s += "_";
        }

        return Pattern.compile("\\p{ASCII}{2}")
                .matcher(s)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
    }
}
