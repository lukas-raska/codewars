package solutions.kyu5.simplePigLatin;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatin {

    public static String pigIt(String str) {

        return Arrays.stream(str.split(" "))
                .map(word -> {
                    if (word.matches("\\p{Alnum}+")) {
                        word = word.substring(1) + word.charAt(0) + "ay";
                    }
                    return word;
                })
                .collect(Collectors.joining(" "));
    }
}
