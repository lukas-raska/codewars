package solutions.kyu7.listFiltering;

import java.util.List;

public class Kata {

    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(e -> e.getClass() == Integer.class)
                .toList();
    }
}
