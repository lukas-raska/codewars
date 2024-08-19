package solutions.kyu4.sumsOfPerfectSquares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfSquaresTest {

    @Test
    void nSquaresFor() {
        assertEquals(4, SumOfSquares.nSquaresFor2(15));
        assertEquals(1, SumOfSquares.nSquaresFor2(16));
        assertEquals(2, SumOfSquares.nSquaresFor2(17));
        assertEquals(2, SumOfSquares.nSquaresFor2(18));
        assertEquals(3, SumOfSquares.nSquaresFor2(19));
    }
}