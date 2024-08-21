package solutions.kyu6.yourOrderPlease;

import java.util.*;
import java.util.stream.Collectors;

public class Order {

       public static String order(String words) {

        return Arrays
                .stream(words.split(" "))
                .sorted(Comparator.comparing(Order::getNumberFromWord))
                .collect(Collectors.joining(" "));
    }

    private static int getNumberFromWord(String word) {
        return Integer.parseInt(
                word.chars()
                        .filter(Character::isDigit)
                        .mapToObj(n -> "" + (char) n)
                        .collect(Collectors.joining())
        );
    }
}
