package solutions.kyu5.uniform_milk_production_UNFINISHED;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static int uniformMilkOutput(int[] milkRates,
                                        int groupSize) {

        int totalGoats = milkRates.length;
        double largestDiff = 0;

        for (int i = 0; i < totalGoats - groupSize; i++) {

            var currentGroup = Arrays.stream(milkRates, i, i + groupSize)
                    .boxed()
                    .collect(Collectors.toList());
            var currentGroupStats = currentGroup.stream().mapToInt(n -> n).summaryStatistics();

            double groupAvg = currentGroupStats.getAverage();
            int groupMax = currentGroupStats.getMax();
            int groupMin = currentGroupStats.getMin();

            var groupWithoutMax = currentGroup.stream().filter(n -> n == groupMax);
            var groupWithoutMin = currentGroup.removeIf(n -> n == groupMin);



        }

        return 0;
    }
}
