package solutions.kyu6.find_the_parity_outlier;

import java.util.*;

public class FindOutlier {

    static int find(int[] integers) {

        int evensCount = 0, oddsCount = 0, lastEven = 0, lastOdd = 0;

        for (int i : integers) {
            if (i % 2 == 0) {
                lastEven = i;
                evensCount++;
            } else {
                lastOdd = i;
                oddsCount++;
            }
            if (evensCount > 1 && oddsCount == 1) {
                return lastOdd;
            }
            if (evensCount == 1 && oddsCount > 1) {
                return lastEven;
            }
        }
        throw new IllegalArgumentException("Array has no unique even or odd element");
    }


}
