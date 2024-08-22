package solutions.kyu7.theBaumSweetSequence;

import java.util.*;

public class BaumSweet implements Iterator<Integer> {

    private List<Integer> sequence = new LinkedList<>();

    @Override
    public boolean hasNext() {
        return this.sequence.size() <= 1000000;
    }

    @Override
    public Integer next() {
        int n = this.sequence.size();
        String nBinary = Integer.toBinaryString(n);
        boolean hasBlockOfOddLengthZeros = Arrays.stream(nBinary.split("1"))
                .map(String::length)
                .anyMatch(zerosLength -> zerosLength % 2 != 0);
        int next = (n==0)? 1 : hasBlockOfOddLengthZeros ? 0 : 1;
        this.sequence.add(next);
        return next;
    }
}
