package solutions.kyu4.sumsOfPerfectSquares;

import java.util.*;

public class SumOfSquares {

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println("Number: " + i + " Squeres counter: " + nSquaresFor(i));
        }
    }

    //algoritmus dle rady chatGPT
    //založen na dynamickém programování, kdy se vytvoří pomocné pole, do kterého ukládám výsledky pro nižší čísla
    //tyto výsledky pak vhodným způsobem použiju pro vyšší čísla
    //není dostatečně časově efektivní pro vysoká čísla - neprojde testy na codewars
    public static int nSquaresFor(int n) {
        int[] minSquaresCount = new int[n + 1];
        Arrays.fill(minSquaresCount, 1, minSquaresCount.length, Integer.MAX_VALUE);
        for (int i = 1; i < minSquaresCount.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                minSquaresCount[i] = Math.min(minSquaresCount[i], minSquaresCount[i - square] + 1);
            }
        }
        return minSquaresCount[n];
    }


}
