package solutions.kyu6.two_sets_of_equal_sum;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateTwoSetsOfEqualSum {

    public static void main(String[] args) {

        createTwoSetsOfEqualSum(3);
    }

    public static List<List<Integer>> createTwoSetsOfEqualSum(int n) {

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        int sumFirst = 0, sumSecond = 0;
        for (int i = n; i > 0; i--) {

            if (sumFirst <= sumSecond) {
                first.add(i);
                sumFirst += i;
            } else {
                second.add(i);
                sumSecond += i;
            }
        }
        return (sumFirst == sumSecond) ? List.of(first, second) : List.of(Collections.emptyList(),
                Collections.emptyList());
    }


}
