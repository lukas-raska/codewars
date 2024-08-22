package solutions.kyu6.findTheUniqueNumber;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Kata {

    public static double findUniq(double[] arr) {

        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findAny()
                .orElseThrow();

    }
}
