package solutions.kyu6.write_number_in_expanded_form;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {

    public static void main(String[] args) {

        System.out.println(expandedForm(70304));

    }

    public static String expandedForm(int num) {

        List<Integer> expandedNumbers = new LinkedList<>();
        int remainder;
        int exponent = 1;

        while (num != 0) {
            remainder = num % 10;
            if (remainder != 0) {
                expandedNumbers.addFirst(remainder * exponent);
            }
            exponent *= 10;
            num /= 10;
        }

        return expandedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));
    }
}
