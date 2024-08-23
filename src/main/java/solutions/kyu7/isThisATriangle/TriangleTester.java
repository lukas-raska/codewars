package solutions.kyu7.isThisATriangle;

import java.util.Arrays;
import java.util.Comparator;

public class TriangleTester {

    public static boolean isTriangle(int a,
                                     int b,
                                     int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        int [] sides = {a,b,c};
        Arrays.sort(sides);
        return sides[2]<sides[0] + sides[1];
    }
}
