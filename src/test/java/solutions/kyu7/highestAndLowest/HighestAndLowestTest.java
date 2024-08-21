package solutions.kyu7.highestAndLowest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestAndLowestTest {

    @Test
    void highAndLow() {

        assertEquals("3 1", HighestAndLowest.highAndLow("1 2 3"));
        assertEquals("42 -9", HighestAndLowest.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
}