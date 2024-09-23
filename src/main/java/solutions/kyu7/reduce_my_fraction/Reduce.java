package solutions.kyu7.reduce_my_fraction;

import java.util.Arrays;

public class Reduce {

    public static int[] myFraction(int[] fractions) {
        int gcd = findGreatestCommonDivisor(fractions[0], fractions[1]);

        return new int[]{fractions[0]/gcd, fractions[1]/gcd};
    }

    /**
     * Count the greatest common divisor by Euclides algorithm
     * @param first
     * @param second
     * @return
     */
    private static int findGreatestCommonDivisor(int first, int second) {

        if (second == 0){
            return first;
        }

        int rest = first % second;
        first = second;
        second = rest;

       return findGreatestCommonDivisor(first,second);
    }


}
