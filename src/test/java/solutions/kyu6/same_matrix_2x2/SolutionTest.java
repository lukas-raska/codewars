package solutions.kyu6.same_matrix_2x2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void SamplesTests() {
        int[][] ms;

//        ms = new int[][] {{1, 2, 3, 4},
//                {3, 1, 4, 2},
//                {4, 3, 2, 1},
//                {2, 4, 1, 3}};
//        assertEquals(1,Solution.countDifferentMatrices(ms));
//
//        ms = new int[][] {{3, 1, 2, 3},
//                {3, 1, 2, 3},
//                {1, 3, 3, 2},
//                {3, 2, 1, 3}};
//        assertEquals(1,Solution.countDifferentMatrices(ms));
//
//        ms = new int[][] {{5, 1, 2, 6},
//                {5, 4, 3, 5},
//                {2, 5, 6, 1}};
//        assertEquals(2,Solution.countDifferentMatrices(ms));

        ms = new int[][] {{1, 2, 2, 1},
                {1, 1, 2, 2},
                {2, 1, 1, 2},
                {2, 1, 2, 1},
                {1, 2, 1, 2}};
        assertEquals(2,Solution.countDifferentMatrices(ms));
    }

}