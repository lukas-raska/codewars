package solutions.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GapInPrimesTest {

    @Test
    void gap() {
    }

    @Test
    void isPrime() {
        assertTrue(GapInPrimes.isPrime(2));
        assertTrue(GapInPrimes.isPrime(3));
        assertTrue(GapInPrimes.isPrime(89));
        assertTrue(GapInPrimes.isPrime(953));
        assertTrue(GapInPrimes.isPrime(421));

        assertFalse(GapInPrimes.isPrime(4));
        assertFalse(GapInPrimes.isPrime(810));
        assertFalse(GapInPrimes.isPrime(1));
        assertFalse(GapInPrimes.isPrime(0));
        assertFalse(GapInPrimes.isPrime(-5));
    }
}