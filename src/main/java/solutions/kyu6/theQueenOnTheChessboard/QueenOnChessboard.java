package solutions.kyu6.theQueenOnTheChessboard;

import java.util.ArrayList;
import java.util.List;

public class QueenOnChessboard {

    private static int ROW_MIN = 1;
    private static int ROW_MAX = 8;
    private static char COL_MIN = 'A';
    private static char COL_MAX = 'H';

    public static List<String> availableMoves(String position) {

        List<String> possibleMoves = new ArrayList<>();

        if (!isValid(position)) {
            return new ArrayList<>();
        }

        int row = getRow(position);
        char col = getCol(position);

        //projedu vnořenými cykly přes řádky a sloupce
        for (char c = COL_MIN; c <= COL_MAX; c++) {
            for (int i = ROW_MIN; i <= ROW_MAX; i++) {
                if (i == row || c == col || i + c == row + col || c - i == col - row) {
                    if (i == row && c == col){
                        continue;
                    }
                    possibleMoves.add(getMove(c, i));
                }
            }
        }

        return possibleMoves;
    }


    private static int getRow(String position) {
        return Integer.parseInt(String.valueOf(position.charAt(1)));
    }

    private static char getCol(String position) {
        return position.charAt(0);
    }

    private static String getMove(char col,
                                  int row) {
        return "%c%d".formatted(col, row);
    }

    private static boolean isValid(String position) {

        if (position == null) {
            return false;
        }

        //test délky vstupu
        if (position.length() != 2) {
            return false;
        }
        //test validity sloupce
        char col = position.charAt(0);
        if (col < COL_MIN || col > COL_MAX) {
            return false;
        }
        //test validity řádku
        char rowChar = position.charAt(1);
        if (!Character.isDigit(rowChar)) {
            return false;
        }
        int row = Integer.parseInt(String.valueOf(rowChar));
        if (row < ROW_MIN || row > ROW_MAX) {
            return false;
        }

        return true;
    }
}


/*OLD
public static List<String> availableMoves(String position) {
    String possibleColumns = "ABCDEFGH";
    String possibleRows = "12345678";
    if (position == null){
        return Collections.emptyList();
    } else if ((!(position instanceof String)) &&
//                 (position.length() != 2) &&
            (!possibleColumns.contains(String.valueOf(position.charAt(0)))) &&
            (!possibleRows.contains(String.valueOf(position.charAt(1))))) {
        return Collections.emptyList();
    } else {
        int columnWithQueen = position.charAt(0) - 'A';
        int rowWithQueen = position.charAt(1) - '1';
        int[][] chessboard = new int[8][8];
        List<String> possibleMoves = new ArrayList<>();

        //possible moves in the row and column
        for (int i = 0; i < chessboard.length; i++) {
            //... in the row
            if (i != columnWithQueen) {
                String possibleRow = String.valueOf(rowWithQueen + 1);
                String possibleColumn = String.valueOf((char) (i + 'A'));
                possibleMoves.add(String.format("\"%s%s\"", possibleColumn, possibleRow));
            }
            //... in the column
            if (i != rowWithQueen) {
                String possibleRow = String.valueOf((i + 1));
                String possibleColumn = String.valueOf((char) ((columnWithQueen) + 'A'));
                possibleMoves.add(String.format("\"%s%s\"", possibleColumn, possibleRow));
            }
        }
        //possible moves in the diagonals
        // 1 - to the left ...
        for (int i = columnWithQueen-1; i >= 0; i--) {
            // ... and up
            for (int j = rowWithQueen-1; j >= 0; j--) {
                if (i==j) {
                    String possibleColumn = String.valueOf((char) (i + 'A'));
                    String possibleRow = String.valueOf((j+1));
                    possibleMoves.add(String.format("\"%s%s\"", possibleColumn, possibleRow));
                }
            }
            // ... and down
            for (int j = rowWithQueen+1; j < chessboard.length; j++) {
                if ((i+j)==(rowWithQueen+columnWithQueen)) {
                    String possibleColumn = String.valueOf((char) (i + 'A'));
                    String possibleRow = String.valueOf((j+1));
                    possibleMoves.add(String.format("\"%s%s\"", possibleColumn, possibleRow));
                }
            }
        }

        // 1 - to the right ...
        for (int i = columnWithQueen+1; i < chessboard.length; i++) {
            // ... and up
            for (int j = rowWithQueen-1; j >= 0; j--) {
                if ((i+j)==(rowWithQueen+columnWithQueen)) {
                    String possibleColumn = String.valueOf((char) (i + 'A'));
                    String possibleRow = String.valueOf((j+1));
                    possibleMoves.add(String.format("\"%s%s\"", possibleColumn, possibleRow));
                }
            }
            // ... and down
            for (int j = rowWithQueen+1; j < chessboard.length; j++) {
                if (i==j) {
                    String possibleColumn = String.valueOf((char) (i + 'A'));
                    String possibleRow = String.valueOf((j+1));
                    possibleMoves.add(String.format("\"%s%s\"", possibleColumn, possibleRow));
                }
            }
        }
        Collections.sort(possibleMoves);
        return possibleMoves;
    }
}*/
