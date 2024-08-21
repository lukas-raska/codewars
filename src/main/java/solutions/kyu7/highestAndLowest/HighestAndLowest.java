package solutions.kyu7.highestAndLowest;

import java.util.Arrays;


public class HighestAndLowest {

    public static String highAndLow(String numbers) {

        //[0] - min, [1] - max
        final int[] extremes = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .forEach(n -> {
                    if (n < extremes[0]) {
                        extremes[0] = n;
                    }
                    if (n > extremes[1]) {
                        extremes[1] = n;
                    }
                });

        return extremes[1] + " " + extremes[0];
    }
}
