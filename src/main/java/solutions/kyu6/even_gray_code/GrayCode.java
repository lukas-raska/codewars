package solutions.kyu6.even_gray_code;

import java.util.stream.IntStream;

public class GrayCode {


    public static String evenGrayCode(int size,
                                      int position) {
        int currentPosition = 0;
        String currentBinary = "0".repeat(size);

        String[] possibleBinaryNumbers = IntStream.rangeClosed(0, (int) (Math.pow(2, size) - 1))
                .mapToObj(Integer::toBinaryString)
                .map(s -> "0".repeat(size - s.length()) + s)
                .toArray(String[]::new);

        if (currentPosition != position) {

            for (String nextBinary : possibleBinaryNumbers) {

                if (differsInEvenBits(currentBinary, nextBinary)) {
                    currentBinary = nextBinary;
                    currentPosition++;
                    if (currentPosition == position) {
                        break;
                    }
                }
            }
        }
        return currentBinary;
    }


    private static boolean differsInEvenBits(String currentBinary,
                                             String nextBinary) {
        int diffCount = 0;

        for (int i = 0; i < currentBinary.length(); i++) {
            if (currentBinary.charAt(i) != nextBinary.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount > 0 && diffCount % 2 == 0;
    }
}
