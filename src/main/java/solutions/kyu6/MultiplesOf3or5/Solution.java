package solutions.kyu6.MultiplesOf3or5;

import java.util.stream.IntStream;

public class Solution {

    public int solution(int number) {

        return IntStream.range(3, number)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}
