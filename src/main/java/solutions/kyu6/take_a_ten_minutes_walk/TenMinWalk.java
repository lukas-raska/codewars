package solutions.kyu6.take_a_ten_minutes_walk;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TenMinWalk {


    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int[] coordinates = new int[2];
        IntStream.range(0, walk.length)
                .mapToObj(i -> walk[i])
                .forEach(dir -> {
                    switch (dir) {
                        case 'n' -> coordinates[1]++;
                        case 's' -> coordinates[1]--;
                        case 'w' -> coordinates[0]--;
                        case 'e' -> coordinates[0]++;
                        default ->
                                throw new IllegalArgumentException("Wrong input data. Unknown direction command: " + dir);
                    }
                });
        return Arrays.equals(coordinates, new int[]{0, 0});
    }
}
