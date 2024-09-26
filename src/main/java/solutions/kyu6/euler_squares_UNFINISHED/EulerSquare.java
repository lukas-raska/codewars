package solutions.kyu6.euler_squares;

import java.util.*;

public class EulerSquare {

    public static void main(String[] args) {

       var eulerSquares = createEulerSquare(3);
    }

    public static int[][][] createEulerSquare(int n) {

        List<int[][]>possibleSquares = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            possibleSquares.add(makeLatinSquare(n,i));
        }
//        int[][] first, second;
//        for (int i = 0; i < n; i++) {
//            first = makeLatinSquare(n, i);
//            for (int j = i + 1; j < n; j++) {
//                second = makeLatinSquare(n, j);
//                if (areOrthogonal(first,second)){
//                    return new int[][][] {first,second};
//                }
//            }
//        }
        throw new NoSuchElementException("Cannot find Euler squares.");
    }

    private static int[][] makeLatinSquare(int n,
                                           int offset) {
        final int[][] latinSquare = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                latinSquare[col][row] = 1 + (offset + col + row) % n;
            }
        }
        return latinSquare;
    }

    private static boolean areOrthogonal(int[][] first,
                                         int[][] second) {
        if (first.length != second.length || first[0].length != second[0].length) {
            throw new IllegalArgumentException("Dimensions of input arrays must be equal.");
        }

        Map<Integer, Integer> matchMap = new HashMap<>(); //key: value in square, value: count of matches

        for (int row = 0; row < first.length; row++) {

            for (int col = 0; col < first[row].length; col++) {

                int firstValue = first[col][row];
                int secondValue = second[col][row];

                if (firstValue == secondValue) {
                    matchMap.merge(firstValue, 1, Integer::sum);
                }

                if (matchMap.containsValue(2)) {
                    return false;
                }
            }
        }
        for (int i = 1; i <= first.length; i++) {
            if (!matchMap.containsKey(i)) {
                return false;
            }
        }

        return true;
    }
}
