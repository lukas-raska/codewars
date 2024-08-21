package solutions.kyu8.gradeBook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassHopperTest {

    private static void doTest(int a, int b, int c, char expected) {
        char actual = GrassHopper.getGrade(a, b, c);
        String message = String.format("for grades %d, %d, %d\n", a, b, c);
        assertEquals(expected, actual, message);
    }

    @Test
    public void testA() {
        doTest(95,90,93, 'A');
        doTest(100,85,96, 'A');
        doTest(92,93,94, 'A');
        doTest(100,100,100, 'A');
    }
    @Test
    public void testB() {
        doTest(70,70,100, 'B');
        doTest(82,85,87, 'B');
        doTest(84,79,85, 'B');
    }
    @Test
    public void testC() {
        doTest(70,70,70, 'C');
        doTest(75,70,79, 'C');
        doTest(60,82,76, 'C');
    }
    @Test
    public void testD() {
        doTest(65,70,59, 'D');
        doTest(66,62,68, 'D');
        doTest(58,62,70, 'D');
    }
    @Test
    public void testF() {
        doTest(44,55,52, 'F');
        doTest(48,55,52, 'F');
        doTest(58,59,60, 'F');
        doTest(0,0,0, 'F');
    }
}