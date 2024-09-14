package solutions.kyu8.find_nearest_square_number;

public class CodeWarsMath {

    public static int nearestSq(final int n) {

        double nearestPerfectSquareBase = Math.round(Math.sqrt(n));
        return (int) (nearestPerfectSquareBase * nearestPerfectSquareBase);

    }
}
