package solutions.kyu7.descendingOrder;

import java.util.Comparator;
import java.util.stream.Collectors;

public class DescendingOrder {

    public static int sortDesc(final int num) {
        return Integer.parseInt(
                String.valueOf(num)
                        .chars()
                        .mapToObj(c -> (char) c)
                        .sorted(Comparator.reverseOrder())
                        .map(String::valueOf)
                        .collect(Collectors.joining())
        );
    }
}
