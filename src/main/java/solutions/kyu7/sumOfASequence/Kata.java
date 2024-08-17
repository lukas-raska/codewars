package solutions.kyu7.sumOfASequence;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Kata {

    public static int sequenceSum(int start,
                                  int end,
                                  int step) {
        int sum = 0;
        int numberToAdd = start;
        while (numberToAdd <= end) {
            sum += numberToAdd;
            numberToAdd += step;
        }
        return sum;
    }
}
