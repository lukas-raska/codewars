package solutions.kyu5.uniform_milk_production;

import org.junit.jupiter.api.Test;
import solutions.kyu5.uniform_milk_production_UNFINISHED.Solution;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void sampleTests() throws Exception {
        assertEquals(3, Solution.uniformMilkOutput(new int[] {4, 2, 9, 0, 8, 5, 2}, 3));
        assertEquals(4, Solution.uniformMilkOutput(new int[] {6, 1, 4, 2, 10, 10, 3}, 4));
        assertEquals(1, Solution.uniformMilkOutput(new int[] {5, 4, 12, 6, 14}, 2));
        assertEquals(1, Solution.uniformMilkOutput(new int[] {5, 12, 4, 6, 14}, 2));
    }
}