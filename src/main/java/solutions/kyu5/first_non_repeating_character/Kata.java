package solutions.kyu5.first_non_repeating_character;

import java.util.stream.Collectors;

public class Kata {

    public static String firstNonRepeatingLetter(String input) {

        var charFrequencies = input.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> charFrequencies.get(Character.toLowerCase(c)) == 1)
                .map(String::valueOf)
                .findFirst()
                .orElse("");
    }
}
