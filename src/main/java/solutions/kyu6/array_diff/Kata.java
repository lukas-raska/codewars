package solutions.kyu6.array_diff;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Kata {

    public static int[] arrayDiff(int[] a,
                                  int[] b) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        if (b == null || b.length == 0) {
            return a;
        }
        Set<Integer> bElements = Arrays.stream(b)
                .boxed()
                .collect(Collectors.toSet());

        return Arrays.stream(a)
                .filter(i -> !bElements.contains(i))
                .toArray();
    }
}
