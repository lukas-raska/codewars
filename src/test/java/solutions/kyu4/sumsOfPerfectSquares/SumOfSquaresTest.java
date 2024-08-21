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

    @Test
    void nSquaresFor2() {
        assertEquals(4, SumOfSquares.nSquaresFor2(15));
        assertEquals(1, SumOfSquares.nSquaresFor2(16));
        assertEquals(2, SumOfSquares.nSquaresFor2(17));
        assertEquals(2, SumOfSquares.nSquaresFor2(18));
        assertEquals(3, SumOfSquares.nSquaresFor2(19));
    }

    @Test
    void nSquaresFor3() {
        assertEquals(4, SumOfSquares.nSquaresFor2(15));
        assertEquals(1, SumOfSquares.nSquaresFor2(16));
        assertEquals(2, SumOfSquares.nSquaresFor2(17));
        assertEquals(2, SumOfSquares.nSquaresFor2(18));
        assertEquals(3, SumOfSquares.nSquaresFor2(19));
    }

    @Test
    void nSquaresFor4() {
        assertEquals(4, SumOfSquares.nSquaresFor2(15));
        assertEquals(1, SumOfSquares.nSquaresFor2(16));
        assertEquals(2, SumOfSquares.nSquaresFor2(17));
        assertEquals(2, SumOfSquares.nSquaresFor2(18));
        assertEquals(3, SumOfSquares.nSquaresFor2(19));
    }

    @Test
    void nSquaresFor5() {
        assertEquals(4, SumOfSquares.nSquaresFor2(15));
        assertEquals(1, SumOfSquares.nSquaresFor2(16));
        assertEquals(2, SumOfSquares.nSquaresFor2(17));
        assertEquals(2, SumOfSquares.nSquaresFor2(18));
        assertEquals(3, SumOfSquares.nSquaresFor2(19));
    }



    @Test
    void isPerfectSquare() {
        assertTrue(SumOfSquares.isPerfectSquare(4));
        assertTrue(SumOfSquares.isPerfectSquare(16));
        assertTrue(SumOfSquares.isPerfectSquare(25));
        assertTrue(SumOfSquares.isPerfectSquare(100));
        assertTrue(SumOfSquares.isPerfectSquare(144));
    }

    @Test
    void hasTwoSquaresSum() {
    }

    @Test
    void hasThreeSquaresSum() {
    }
}