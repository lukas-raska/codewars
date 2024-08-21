package solutions.kyu8.evenOrOdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenOrOddTest {

    @Test
    void evenOrOdd() {
        assertEquals("Even", EvenOrOdd.evenOrOdd(2));
        assertEquals("Even", EvenOrOdd.evenOrOdd(10));
        assertEquals("Even", EvenOrOdd.evenOrOdd(-6));
        assertEquals("Odd", EvenOrOdd.evenOrOdd(5));
        assertEquals("Odd", EvenOrOdd.evenOrOdd(1));
        assertEquals("Odd", EvenOrOdd.evenOrOdd(-3));
    }
}