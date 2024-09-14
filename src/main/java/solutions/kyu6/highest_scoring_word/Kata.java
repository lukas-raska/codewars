package solutions.kyu6.highest_scoring_word;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {


    private final static Map<Character, Integer> CHAR_VALUES = IntStream
            .rangeClosed('a', 'z')
            .mapToObj(c -> (char) c)
            .collect(Collectors.toMap(c -> c, c -> c - 'a' + 1));


    public static String high(String s) {

        if (s == null) {
            throw new IllegalArgumentException("Invalid input string: " + s);
        }

        final Map<String, Integer> scores = Arrays
                .stream(s.split(" "))
                .collect(
                        Collectors.toMap(
                                word -> word,
                                Kata::getScore,
                                (a, _) -> a,
                                LinkedHashMap::new));

        final int maxScore = scores.values().stream().max(Comparator.naturalOrder()).orElse(0);

        return scores.entrySet().stream()
                .filter(entry -> entry.getValue() == maxScore)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }

    private static int getScore(String word) {

        return word.chars()
                .mapToObj(c -> (char) c)
                .filter(CHAR_VALUES::containsKey)
                .map(CHAR_VALUES::get)
                .reduce(0, Integer::sum);
    }
}
