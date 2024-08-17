package solutions.kyu6.MultiplesOf3or5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void solutionNegativeNumberTest() {
        assertEquals(0, solution.solution(-1));
    }

    @Test
    void solutionZeroTest() {
        assertEquals(0, solution.solution(0));
    }

    @Test
    void input3ShouldGive0() {
        assertEquals(0, solution.solution(3));
    }

    @Test
    void input5ShouldGive3() {
        assertEquals(3, solution.solution(5));
    }

    @Test
    void solutionForTenShouldGive23() {
        assertEquals(23,
                solution.solution(10));
    }
}