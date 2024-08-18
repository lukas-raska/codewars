package solutions.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GapInPrimesTest {

    @Test
    void findPrimeGap() {
        System.out.println("Fixed Tests");
        assertEquals("[101, 103]", Arrays.toString(GapInPrimes.findPrimeGap(2,100,110)));
        assertEquals("[103, 107]", Arrays.toString(GapInPrimes.findPrimeGap(4,100,110)));
        assertEquals(null, GapInPrimes.findPrimeGap(6,100,110));
        assertEquals("[359, 367]", Arrays.toString(GapInPrimes.findPrimeGap(8,300,400)));
        assertEquals("[337, 347]", Arrays.toString(GapInPrimes.findPrimeGap(10,300,400)));
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