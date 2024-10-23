package solutions.kyu5.i_am_all_alone;

import java.util.*;

public class Dinglemouse {

    public enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    public static void main(String[] args) {

        char[][] house = {
                "  o                o        #######".toCharArray(),
                "###############             #     #".toCharArray(),
                "#             #        o    #     #".toCharArray(),
                "#  X          ###############     #".toCharArray(),
                "#                                 #".toCharArray(),
                "###################################".toCharArray()
        };

        char[][] house2 = {
                "#################             ".toCharArray(),
                "#     o         #   o         ".toCharArray(),
                "#          ######        o    ".toCharArray(),
                "####       #                  ".toCharArray(),
                "   #       ###################".toCharArray(),
                "   #                         #".toCharArray(),
                "   #                  X      #".toCharArray(),
                "   ###########################".toCharArray()
        };

        System.out.println(allAlone(house2));
    }

    public static boolean allAlone(char[][] house) {

        int[] currentPoint;
        Queue<int[]> pointQueue = new LinkedList<>();
        pointQueue.add(locatePotus(house));
        final char elfMark = 'o';
        final char wallMark = '#';
        final char visitedMark = 'V';
        int x, y;

        while (!pointQueue.isEmpty()) {

            currentPoint = pointQueue.poll();
            x = currentPoint[1];
            y = currentPoint[0];

            for (Direction direction : Direction.values()) {

                boolean elfOnTheNextSquare = checkNextSquare(x, y, elfMark, direction, house);
                if (elfOnTheNextSquare) {
                    return false;
                }

                boolean wallOnNextSquare = checkNextSquare(x, y, wallMark, direction, house);
                boolean visitedFieldOnNextSquare = checkNextSquare(x, y, visitedMark, direction, house);
                if (!wallOnNextSquare && !visitedFieldOnNextSquare) {
                    processNextSquare(x, y, direction, house, pointQueue);
                }
            }
        }
        return true;
    }

    private static void processNextSquare(int x,
                                          int y,
                                          Direction direction,
                                          char[][] house,
                                          Queue<int[]> queue) {
        int xNext = xNext(x, direction);
        int yNext = yNext(y, direction);
        queue.add(new int[]{yNext, xNext});
        house[yNext][xNext] = 'V';
    }

    private static boolean checkNextSquare(int x,
                                           int y,
                                           char mark,
                                           Direction direction,
                                           char[][] house) {
        int xNext = xNext(x, direction);
        int yNext = yNext(y, direction);

        return house[yNext][xNext] == mark;
    }


    private static int xNext(int x,
                             Direction direction) {
        return switch (direction) {
            case UP, DOWN -> x;
            case LEFT -> x - 1;
            case RIGHT -> x + 1;
        };
    }

    private static int yNext(int y,
                             Direction direction) {
        return switch (direction) {
            case LEFT, RIGHT -> y;
            case UP -> y - 1;
            case DOWN -> y + 1;
        };
    }


    private static int[] locatePotus(
            char[][] house) {
        final char pontusMark = 'X';
        for (int y = 0; y < house.length; y++) {
            for (int x = 0; x < house[y].length; x++) {
                if (house[y][x] == pontusMark) {
                    return new int[]{y, x};
                }
            }
        }
        throw new IllegalArgumentException(
                "Invalid data. Searched character [%c] not found".formatted(pontusMark)
        );
    }


    private static void print(char[][] house) {
        for (var row : house) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
        System.out.println("-".repeat(house[0].length));
    }
}
