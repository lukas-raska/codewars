package solutions.kyu4.sumsOfPerfectSquares;

import java.util.*;

public class SumOfSquares {


    public static void main(String[] args) {

        System.out.println(nSquaresFor5(56));
        for (int i = 1; i < 100; i++) {
            System.out.println("n =  " + i + " DP: " + nSquaresFor(i) + " , My: " + nSquaresFor2(i) + ", BDFS: " + nSquaresFor3(i) + ", BDFS2: " + nSquaresFor4(i) +
                    ", My2: " + nSquaresFor5(i));
        }


//        var numbers = List.of(1, 17, 27, 37, 47, 57, 67, 77, 87, 97);
//        numbers.forEach(i -> System.out.println("n =  " + i + " DP: " + nSquaresFor(i) + " , My: " + nSquaresFor2(i) + ", BDFS: " + nSquaresFor3(i)));
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

    // metoda pomocí BFS - navrženo chatGPT - rovněž neefektivní, neprojde testy
    public static int nSquaresFor3(int n) {

        var squares = findPossibleSquares(n);
        squares.sort(Comparator.naturalOrder());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int remainder = queue.poll();
                for (int square : squares) {
                    if (remainder == square) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        queue.offer(remainder - square);
                    }

                }
            }
        }
        return level;
    }

    //rovněž použití BFS, tentokrát dosazovány možné čtverce sestupně řazené
    public static int nSquaresFor4(int n) {

        var squares = findPossibleSquares(n);

        // Inicializace fronty pro BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(n);
        visited.add(n);

        int level = 0;

        // BFS prohledávání
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int square : squares) {
                    int next = current - square;
                    if (next == 0) {
                        return level;
                    }
                    if (next > 0 && !visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }

        return level;
    }

    public static int nSquaresFor5(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (hasTwoSquaresSum(n)) {
            return 2;
        }
        if (hasThreeSquaresSum(n)) {
            return 3;
        }
        return 4; //jediná zbývající hodnota (vyplývá z Lagrangeovy věty o čtyřech čtvercích: https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem)
    }

    /**
     * Vrátí list možných čtverců (sestupně řezených), ze kterých lze skládat dané číslo n
     *
     * @param n - přirozené číslo
     * @return - seznam čtverců
     */
    private static List<Integer> findPossibleSquares(int n) {
        List<Integer> possibleSquares = new ArrayList<>();
        int maxBase = (int) Math.sqrt(n);
        for (int i = maxBase; i > 0; i--) {
            possibleSquares.add(i * i);
        }
        return possibleSquares;
    }

    public static boolean isPerfectSquare(int number) {
        return Math.sqrt(number) % 1 == 0;
    }

    /**
     * Metoda ověřuje, zda lze zadané číslo složit ze součtu dvou čtverců.
     * Vychází z Fermatovy teorie o součtu dvou čtverců.
     * (<a href="https://en.wikipedia.org/wiki/Sum_of_two_squares_theorem">...</a>)
     * Celé číslo větší než 1 lze zapsat jako součet dvou čtverců právě tehdy, když jeho prvočíselný rozklad
     * NEOBSAHUJE žádný faktor 'p^k', kde p=4k+3 a 'k' je liché číslo.
     *
     * @param number
     * @return
     */
    public static boolean hasTwoSquaresSum(int number) {

        //číslo 2 je prvočíslo ve tvrau '4k+1', nikoli '4k+3', lze jej tedy z posuzování vynechat. Postupným dělením
        // eliminuju, až zbyde pouze lichý faktor
        while (number % 2 == 0) {
            number /= 2;
        }
        for (int i = 2; i * i <= number; i++) {
            int k = 0;
            while (number % i == 0) { //hledám velikost exponentu 'k'
                number /= i;
                k++;
            }
            // Pokud máme prvočíslo ve tvaru 4k+3 s lichým počtem exponentů, nelze rozložit na dva
            // čtverce
            if (i % 4 == 3 && k % 2 != 0) {
                return false;
            }
        }
        //zbývá posoudit, zda lze zbylý faktor zapsat ve tvaru 4k+3
        return number % 4 != 3;

    }

    /**
     * Metoda ověřuje, zda lze dané přirozené číslo zapsat jako součet 3 čtverců. Vychází z Legendrovy věty o třech
     * čtvercích (<a href="https://en.wikipedia.org/wiki/Legendre%27s_three-square_theorem">...</a>)
     * Číslo lze zapsat jako součet 3 čtverců právě tehdy, když jej NELZE zapsat ve tvaru 4^a(8b+7),
     *
     * @param number Dané přirozené číslo
     * @return TRUE, pokud jej lze zapsat jako součet 3 čtverců
     */
    public static boolean hasThreeSquaresSum(int number) {
        while (number % 4 == 0) { //pomyslné hledání koeficientu 'a' pomocí ověřování dělitelnosti číslem 4 (počet dělení
            // udává 'a')
            number /= 4;
        }
        //podmínka ověřuje existenci celočíselného koeficientu 'b'. Pokud není splněna, zadané číslo nelze zapsat ve
        // tvaru 4^a(8b+7) a platí tedy, že jej lze zapsat jako součet 3 čtverců
        return (number % 8 != 7);

    }
}
