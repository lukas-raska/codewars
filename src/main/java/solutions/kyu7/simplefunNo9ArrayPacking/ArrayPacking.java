package solutions.kyu7.simplefunNo9ArrayPacking;


import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ArrayPacking {

    public static void main(String[] args) {

        arrayPacking(new int[]{255, 85, 0});
    }

    public static long arrayPacking(int[] arr) {
        var binary = Arrays.stream(arr).mapToObj(ArrayPacking::toEightBits).collect(Collectors.toList());
        Collections.reverse(binary);
        return Long.parseLong(String.join("", binary), 2);
    }

    private static String toEightBits(int number) {
        if (number < 0 || number > 255) {
            throw new IllegalArgumentException("Number " + number + " cannot be represent in 8 bit format");
        }
        String binary = Integer.toBinaryString(number);
        String zeroPrefix = "0".repeat(8 - binary.length());
        return zeroPrefix + binary;
    }
}
