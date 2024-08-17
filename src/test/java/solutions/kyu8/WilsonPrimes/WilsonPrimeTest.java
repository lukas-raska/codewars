package solutions.kyu8.WilsonPrimes;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
class WilsonPrimeTest {

    @Test
    void amIWilson() {

        assertFalse(WilsonPrime.amIWilson(-1));
        assertFalse(WilsonPrime.amIWilson(Integer.MIN_VALUE));
        assertFalse(WilsonPrime.amIWilson(0));
        assertFalse(WilsonPrime.amIWilson(1));
        assertTrue(WilsonPrime.amIWilson(5));
        assertTrue(WilsonPrime.amIWilson(13));
        assertTrue(WilsonPrime.amIWilson(563));
    }

    @Test
    void factorial() {
        assertThrows(ArithmeticException.class, () -> WilsonPrime.factorial(-1));
        assertEquals(BigInteger.ONE, WilsonPrime.factorial(0));
        assertEquals(BigInteger.ONE, WilsonPrime.factorial(1));
        assertEquals(BigInteger.valueOf(120), WilsonPrime.factorial(5));
        assertEquals(BigInteger.valueOf(3628800), WilsonPrime.factorial(10));
        assertEquals(new BigInteger("1307674368000"),WilsonPrime.factorial(15) );
        assertEquals(new BigInteger("2432902008176640000"),WilsonPrime.factorial(20) );
    }
}