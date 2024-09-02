package solutions.kyu4.howManyNumbersIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LongSummaryStatistics;

public class HowManyNumbers_II {

    public static void main(String[] args) {

        generateNonDecreasingNumbers(2, 2, 0, new ArrayList<>());
    }

    public static List<Long> findAll(final int sumDigits,
                                     final int numDigits) {

        LongSummaryStatistics statistics = generateNonDecreasingNumbers(numDigits)
                .stream()
                .filter(n -> sumDigits == sumDigits(n))
                .mapToLong(n -> n)
                .summaryStatistics();

        return (statistics.getCount() == 0) ?
                Collections.emptyList() :
                List.of(
                        statistics.getCount(),
                        statistics.getMin(),
                        statistics.getMax());
    }

    private static List<Long> generateNonDecreasingNumbers(int numDigits) {

        List<Long> result = new ArrayList<>();
        generateNonDecreasingNumbers(1, numDigits, 0, result);

        return result;
    }

    /**
     * Metoda rekurzivním voláním generuje neklesající čísla (navrženo chatGPT)
     *
     * @param startDigit      - udává první použitou číslici
     * @param remainingDigits - udává počet cifer
     * @param currentNumber   - generované číslo
     * @param results         - seznam pro uložení čísel
     */
    public static void generateNonDecreasingNumbers(int startDigit,
                                                    int remainingDigits,
                                                    long currentNumber,
                                                    List<Long> results) {

        if (remainingDigits == 0) {
            results.add(currentNumber);
            return;
        }

        // Pro každou možnou číslici od startDigit do 9 generuj nové číslo přidáním číslice k currentNumber
        // a sniž počet zbývajících číslic o 1, přičemž pokračuj v rekurzi pro zbývající číslice.
        for (int digit = startDigit; digit <= 9; digit++) {
            generateNonDecreasingNumbers(
                    digit,
                    remainingDigits - 1,
                    currentNumber * 10 + digit, results);
        }
    }


    private static long sumDigits(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
