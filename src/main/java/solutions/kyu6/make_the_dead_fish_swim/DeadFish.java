package solutions.kyu6.make_the_dead_fish_swim;

import java.util.LinkedList;
import java.util.List;

public class DeadFish {

    public static int[] parse(String data) {
        List<Integer> results = new LinkedList<>();
        int value = 0;
        for (char c : data.toCharArray()) {
            switch (c) {
                case 'i' -> value++;
                case 'd' -> value--;
                case 's' -> value = value * value;
                case 'o' -> results.add(value);
                default -> throw new IllegalArgumentException("Unknown command: " + c);
            }
        }
        return results.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
