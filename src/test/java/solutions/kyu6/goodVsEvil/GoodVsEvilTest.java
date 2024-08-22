package solutions.kyu6.goodVsEvil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodVsEvilTest {

    @Test
    public void testEvilWin() {
        assertEquals( "Battle Result: Evil eradicates all trace of Good",
                GoodVsEvil.battle("1 1 1 1 1 1", "1 1 1 1 1 1 1"));
    }

    @Test
    public void testGoodWin() {
        assertEquals( "Battle Result: Good triumphs over Evil",
                GoodVsEvil.battle("0 0 0 0 0 10", "0 1 1 1 1 0 0"));
    }

    @Test
    public void testTie() {
        assertEquals("Battle Result: No victor on this battle field",
                GoodVsEvil.battle("1 0 0 0 0 0", "1 0 0 0 0 0 0"));
    }

    @Test
    public void bigDataTest(){
        assertEquals("Battle Result: Evil eradicates all trace of Good",
                GoodVsEvil.battle("6997 3993 2765 2316 9695 529", "6954 3725 4436 7992 3019 2238 1704"));
    }

    @Test
    public void bigDataTest2(){
        assertEquals("Battle Result: Evil eradicates all trace of Good",
                GoodVsEvil.battle("3708 5610 6506 6900 8836 1269", "9553 3223 1502 5702 8441 707 4923"));
    }



}