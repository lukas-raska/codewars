package solutions.kyu6.mexican_wawe;

import java.util.ArrayList;
import java.util.List;

public class MexicanWave {

    public static String[] wave(String str) {
        List<String> results = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                results.add(
                        str.substring(0, i) + String.valueOf(str.charAt(i)).toUpperCase() +
                                str.substring(i + 1));
            }
        }
        return results.toArray(new String[0]);
    }
}
