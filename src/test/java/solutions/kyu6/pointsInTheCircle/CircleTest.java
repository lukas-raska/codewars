package solutions.kyu6.pointsInTheCircle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    public void test1() {
        assertEquals(5,Circle.pointsNumber(1));
        assertEquals(13,Circle.pointsNumber(2));
        assertEquals(29,Circle.pointsNumber(3));
        assertEquals(81,Circle.pointsNumber(5));
        assertEquals(3141549,Circle.pointsNumber(1000));
    }

}