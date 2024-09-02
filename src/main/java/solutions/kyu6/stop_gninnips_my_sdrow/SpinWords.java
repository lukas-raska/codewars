package solutions.kyu6.stop_gninnips_my_sdrow;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {

    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> word.length() < 5 ? word : reverse(word))
                .collect(Collectors.joining(" "));

    }

    private static String reverse(String word) {
        StringBuilder result = new StringBuilder(word);
        return result.reverse().toString();
    }
}
