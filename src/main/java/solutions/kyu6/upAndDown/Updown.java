package solutions.kyu6.upAndDown;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Updown {

    public static void main(String[] args) {

        String testString = "after be arrived two My so";
        System.out.println(arrange(testString));

    }

    public static String arrange(String str) {

        String[] words = str.split(" ");

        for (int i = 0; i < words.length - 1; i++) {
            boolean shouldSwap = (i % 2 == 0) ?
                    words[i].length() > words[i + 1].length() :
                    words[i].length() < words[i + 1].length();
            if (shouldSwap) {
                swap(words, i, i + 1);
            }
        }

        IntStream.range(0, words.length)
                .forEach(i -> words[i] = (i % 2 == 0) ? words[i].toLowerCase() : words[i].toUpperCase());

        return String.join(" ", words);
    }

    private static void swap(String[] words,
                             int i,
                             int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }


}
