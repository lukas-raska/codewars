package solutions.kyu4.sumsOfPerfectSquares;

import java.util.*;

public class SumOfSquares {


    public static void main(String[] args) {

        var numbers = List.of(1000054, 17, 27, 37, 47, 57, 67, 77, 87, 97);
        numbers.forEach(i -> System.out.println("Number: " + i + " Right counter: " + nSquaresFor(i) + " , MyCounter: " + nSquaresFor2(i) + ", IterCount: " + iterCountMap.get(i)));
        ;


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


    //moje řešení
    //ačkoli kód je celkem škaredý, ukázalo se časově efektivnější než předchozí
    //projde testy easy, medium, hard, neprojde extreme testy
    public static int nSquaresFor2(int n) {

        final List<Integer> squares = findPossibleSquares(n);
        int size = squares.size();


        if (squares.getFirst() == n) {
            return 1;   // pokud je samotné číslo dokonalým čtvercem
        }

        //zkouším kombinace 2 čtverců
        for (int i = 0; i < size; i++) {

            for (int j = i; j < size; j++) {

                if (squares.get(i) + squares.get(j) == n) {

                    return 2;
                }
            }
        }
        //pokud nenaleznu kombinaci 2 čtverců, hledám kombinaci 3
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                for (int k = j; k < size; k++) {
                    if (squares.get(i) + squares.get(j) + squares.get(k) == n) {
                        return 3;
                    }
                }
            }
        }

        return 4; //pokud není nalezena kombinace 1,2,3 čtverců, vrátím 4, což je dle Lagrangeovy věty max. možná
        // hodnota
    }

    private static List<Integer> findPossibleSquares(int n) {
        List<Integer> possibleSquares = new ArrayList<>();
        int maxBase = (int) Math.sqrt(n);
        for (int i = maxBase; i > 0; i--) {
            possibleSquares.add(i * i);
        }
        return possibleSquares;
    }
}
