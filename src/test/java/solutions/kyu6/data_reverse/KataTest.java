package solutions.kyu6.data_reverse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {

    private static void doTest(int[] input, int[] expected) {
        String message = String.format("for input = %s\n", Arrays.toString(input));
        int[] actual = Kata.dataReverse(input);
        assertArrayEquals(expected, actual, message);
    }
    @Test
    public void fixedTests() {
        doTest(
                new int[] {0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0},
                new int[] {1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1}
        );
        doTest(
                new int[] {1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1},
                new int[] {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}
        );
        doTest(new int[0], new int[0]);
        doTest(new int[] {1, 0, 1, 0, 0, 1, 0, 1}, new int[] {1, 0, 1, 0, 0, 1, 0, 1});
    }
}