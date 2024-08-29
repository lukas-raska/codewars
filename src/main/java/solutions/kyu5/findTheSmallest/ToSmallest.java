package solutions.kyu5.findTheSmallest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToSmallest {

    public static void main(String[] args) {

        long n = 935855753;

        System.out.printf("%s, %s%n", n, Arrays.toString(smallest(n)));
    }

    public static long[] smallest(long n) {

        List<Integer> originalDigits = getDigitsOfNumber(n);
        long min = n;
        int minIndexFrom = originalDigits.size() - 1;
        int minIndexTo = originalDigits.size() - 1;


        //řešení pomocí brute force. Ve vnějším cyklu vyjmu číslici na indexu i
        for (int i = 0; i < originalDigits.size(); i++) {

            List<Integer> modifiedDigits = new ArrayList<>(originalDigits);
            int currentDigit = modifiedDigits.remove(i);

            //ve vnitřním číslici zkouším vkládat na různé pozice...
            for (int j = 0; j <= modifiedDigits.size(); j++) {

                if (j == modifiedDigits.size()) {
                    modifiedDigits.add(currentDigit);
                } else {
                    modifiedDigits.add(j, currentDigit);
                }

                //a testuji zda je číslo novým minimem. Případně aktualizuji hodnoty
                long currentNumber = assembleNumberFromDigits(modifiedDigits);
                if (currentNumber < min) {
                    min = currentNumber;
                    minIndexFrom = i;
                    minIndexTo = j;
                } else if (currentNumber == min) {
                    if (i < minIndexFrom) {
                        minIndexFrom = i;
                    } else if (i == minIndexFrom) {
                        if (j < minIndexTo) {
                            minIndexTo = j;
                        }
                    }
                }
                modifiedDigits.remove(j);
            }
        }
        return new long[]{min, minIndexFrom, minIndexTo};
    }

    private static List<Integer> getDigitsOfNumber(long n) {
        return String.valueOf(n)
                .chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
    }

    private static long assembleNumberFromDigits(List<Integer> digits) {
        long number = 0;
        for (int i = 0; i < digits.size(); i++) {
            long tensOrder = (long) Math.pow(10, digits.size() - 1 - i);
            number += digits.get(i) * tensOrder;
        }
        return number;
    }

}