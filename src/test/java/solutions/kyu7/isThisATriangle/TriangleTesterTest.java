package solutions.kyu7.isThisATriangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTesterTest {

    private static void doTest(boolean expected, int a, int b, int c) {
        boolean actual = TriangleTester.isTriangle(a, b, c);
        String message = String.format("a = %d, b = %d, c = %d", a, b, c);
        assertEquals(expected, actual, message);
    }

    @Test
    public void sampleTests() {
        doTest(true,  1,2,2);
        doTest(false, 7,2,2);
        doTest(true, 2,2,2);
    }
}