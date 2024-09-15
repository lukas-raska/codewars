package solutions.kyu6.plus_one_array.solutionV2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneArrayTest {
    @Test
    public void exampleTests() {
        doTest(new int[]{2, 3, 9}, new int[]{2, 4, 0});
        doTest(new int[]{4, 3, 2, 5}, new int[]{4, 3, 2, 6});
        doTest(new int[]{1, -9}, null);
    }

    @Test
    public void bigArraysTests() {
        doTest(
                new int[]{9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7},
                new int[]{9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 8});
    }

    private static void doTest(final int[] arr,
                               final int[] expected) {
        int[] actual = PlusOneArray.upArray(arr);
        String arrAsString = Arrays.toString(arr);
        assertArrayEquals(expected, actual, "Incorrect answer for arr = " + arrAsString);
    }
}