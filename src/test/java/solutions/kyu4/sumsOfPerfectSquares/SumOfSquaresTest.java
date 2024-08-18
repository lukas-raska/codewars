package solutions.kyu4.sumsOfPerfectSquares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSquaresTest {

    @Test
    void nSquaresFor() {
        assertEquals(4, SumOfSquares.nSquaresFor(15));
        assertEquals(1, SumOfSquares.nSquaresFor(16));
        assertEquals(2, SumOfSquares.nSquaresFor(17));
        assertEquals(2, SumOfSquares.nSquaresFor(18));
        assertEquals(3, SumOfSquares.nSquaresFor(19));
    }
}