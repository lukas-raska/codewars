package solutions.kyu6.beginYourDayWithAChallengeButAnEasyOne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    void doTest(int n, String[] expected) {
        String[] actual = Kata.oneTwoThree(n);
        String message = "oneTwoThree(" + n + ") should return [\"" + expected[0] + "\", \"" + expected[1] + "\"]," +
                " but returned [\"" + actual[0] + "\",\"" + actual[1] + "\"].";

        assertArrayEquals(expected, actual, message);
    }

    @Test
    void basicTests() {
        doTest(0, new String[] {"0", "0"});
        doTest(1, new String[] {"1", "1"});
        doTest(2, new String[] {"2", "11"});
        doTest(3, new String[] {"3", "111"});
        doTest(19, new String[] {"991", "1111111111111111111"});

    }

    @Test
    void randomTests(){
        doTest(174, new String[] {"99999999999999999993", "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"});
        doTest(189, new String[] {"999999999999999999999", "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"});
    }


}