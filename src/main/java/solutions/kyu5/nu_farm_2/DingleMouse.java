package solutions.kyu5.nu_farm_2;

import java.util.Arrays;
import java.util.Scanner;

public class DingleMouse {

    public static void main(String[] args) {

        String testingTree1 = """
                .\\..\\..o//.o....\\o.
                .\\./\\\\.///....\\.o\\.
                .oo.\\..o/\\....\\\\o/.
                ..o.o\\\\//.o/.......
                .\\/.\\/.\\.o\\oo\\o.oo.
                ././..//o..o..oo\\o.
                .\\.o\\oo/\\.o.o..\\.\\.
                .\\.\\..o/oo\\...//...
                """;

        String testingTree2 = """
                .o......
                ./.o.o/.
                .///....
                ...///..
                """;

        var treeArr = makeTree(testingTree1);
        var treeArr2 = makeTree(testingTree2);

        var fallenNuts = shakeTree(treeArr);
        System.out.println(Arrays.toString(fallenNuts));
        System.out.println(Arrays.toString(shakeTree(treeArr2)));


    }

    private static char[][] makeTree(String tree) {

        return new Scanner(tree).tokens()
                .map(String::toCharArray)
                .toArray(char[][]::new);
    }

    public static int[] shakeTree(final char[][] tree) {

        int width = tree[0].length;
        int[] nuts = new int[width];

        for (char[] level : tree) {

            for (int j = 1; j < width - 1; j++) {

                char current = level[j];

                if (current == 'o') {
                    nuts[j]++;
                    continue;
                }

                if (nuts[j] != 0) {
                    if (current == '/' || current == '\\') {
                        bounce(nuts, level, j, current);
                    }
                }
            }
        }

        return nuts;
    }

    private static void bounce(int[] nuts,
                               char[] treeLevel,
                               int index,
                               char charForBounce) {

        int dx = switch (charForBounce) {
            case '/' -> -1;
            case '\\' -> 1;
            default -> throw new IllegalArgumentException();
        };

        char oppositeBranch = switch (charForBounce){
            case '/'-> '\\';
            case '\\'-> '/';
            default -> throw new IllegalArgumentException();
        };

        int shift = 0;
        while (treeLevel[index + (dx * shift)] == charForBounce) {
            shift++;
        }

        if (treeLevel[index + (dx * shift)] == oppositeBranch) { //nuts stucked
            nuts[index] = 0;

        } else { //nuts bounced
            int temp = nuts[index];
            nuts[index] = 0;
            nuts[index + (dx * shift)] += temp;
        }

    }
}
