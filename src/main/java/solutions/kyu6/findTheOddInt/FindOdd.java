package solutions.kyu6.findTheOddInt;

import java.util.*;
import java.util.stream.Stream;

public class FindOdd {

    public static int findIt(int[] a) {

        List<Integer>list = Arrays.stream(a).boxed().toList();

        return list.stream()
                .filter(i -> Collections.frequency(list, i) % 2 != 0)
                .findFirst()
                .orElseThrow();

    }
}
