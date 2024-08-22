package solutions.kyu7.theHighestProfitWins;

import java.util.Arrays;

public class MinMax {

    public static int[] minMax(int[] arr) {
        var stats = Arrays.stream(arr).summaryStatistics();
        return new int[]{stats.getMin(), stats.getMax()};

    }
}
