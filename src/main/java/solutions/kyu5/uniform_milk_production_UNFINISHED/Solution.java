package solutions.kyu5.uniform_milk_production_UNFINISHED;

import java.util.Arrays;

public class Solution {
    public static int uniformMilkOutput(int[] milkProductions,
                                        int groupSize) {

        int goatForTheButcherIndex = 0;
        double maxDeviation = 0;

        double sum = Arrays.stream(milkProductions, 0, groupSize).sum();

        for (int i = 0; i < milkProductions.length - groupSize; i++) {

            double avg = sum / groupSize;

            for (int j = i; j < i + groupSize; j++) {

                double deviation = Math.abs(milkProductions[j] - avg);

                if (deviation > maxDeviation) {
                    maxDeviation = deviation;
                    goatForTheButcherIndex = j;
                }
            }

            sum = sum - milkProductions[i] + milkProductions[i + groupSize];

        }
        return goatForTheButcherIndex;
    }
}
