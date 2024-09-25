package solutions.kyu7.latin_squares;

public class LatinSquares {



    public static int[][] makeLatinSquare(int n) {
        final int[][] latinSquare = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                latinSquare[col][row] = 1 + (col + row) % n;
            }
        }
        return latinSquare;
    }
}
