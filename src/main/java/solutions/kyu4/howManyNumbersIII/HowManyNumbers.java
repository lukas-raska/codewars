package solutions.kyu4.howManyNumbersIII;

import java.util.*;
import java.util.stream.LongStream;

public class HowManyNumbers {


    /**
     * Pomocná mapa, do které se ukládají pro konkrétní počet číslic možná čísla
     * Key - numDigits
     * Value - pole možných čísel s neklesajícími
     */
    static final Map<Integer, long[]> numbersWithNonDecreasingDigitsValue = new HashMap<>();

    public static List<Long> findAll(final int sumDigits,
                                     final int numDigits) {

        final long lowerLimit = getMin(numDigits);
        final long upperLimit = getMax(numDigits);

        LongSummaryStatistics filteredNumbersStatistics = Arrays
                .stream(
                        numbersWithNonDecreasingDigitsValue.computeIfAbsent(
                                numDigits,
                                key -> LongStream
                                        .rangeClosed(lowerLimit, upperLimit)
                                        .filter(HowManyNumbers::hasNonDecreasingDigitValue)
                                        .toArray()))
                .filter(n -> sumDigits == sumDigits(n))
                .summaryStatistics();


        return (filteredNumbersStatistics.getCount() == 0) ?
                Collections.emptyList() :
                List.of(
                        filteredNumbersStatistics.getCount(),
                        filteredNumbersStatistics.getMin(),
                        filteredNumbersStatistics.getMax());
    }




    private static long sumDigits(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


    private static long getMin(final int numberOfDigits) {
        long min = (numberOfDigits == 1) ? 0 : 1;
        for (int i = 1; i < numberOfDigits; i++) {
            min *= 10;
        }
        return min;
    }


    private static long getMax(final int numberOfDigits) {
        long max = 1;
        for (int i = 1; i <= numberOfDigits; i++) {
            max *= 10;
        }
        return max - 1;
    }


    private static boolean hasNonDecreasingDigitValue(long number) {
        long prevDigit = 10; //počáteční hodnota může být jakékoli číslo vyšší než nejvyšší číslice
        while (number > 0) {
            long currentDigit = number % 10;
            if (currentDigit > prevDigit) {
                return false;
            }
            prevDigit = currentDigit;
            number /= 10;
        }
        return true;
    }
}
