package solutions.kyu6.duplicate_encoder;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateEncoder {

    static String encode(String word) {

        word = word.toLowerCase();
        StringBuilder result = new StringBuilder();

        Map<Character, Long> charFrequencies = word.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        for (char c : word.toCharArray()) {
            result.append(
                    charFrequencies.get(c) == 1 ? "(" : ")"
            );
        }
        return result.toString();
    }
}

