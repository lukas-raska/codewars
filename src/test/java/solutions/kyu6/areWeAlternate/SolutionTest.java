package solutions.kyu6.areWeAlternate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void exampleTests() {
        assertTrue(Solution.isAlt("amazon"));
        assertEquals(false, Solution.isAlt("apple"));
        assertEquals(true, Solution.isAlt("banana"));
    }
}