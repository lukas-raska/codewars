package solutions.kyu6.mexican_wawe;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MexicanWaveTest {

    @Test
    public void basicTest1() {
        String[] result = new String[] { "Hello", "hEllo", "heLlo", "helLo", "hellO" };
        assertArrayEquals(result, MexicanWave.wave("hello"),"it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest2() {
        String[] result = new String[] { "Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS" };
        assertArrayEquals(result, MexicanWave.wave("codewars"), "it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest3() {
        String[] result = new String[] { };
        assertArrayEquals(result, MexicanWave.wave(""),"it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest4() {
        String[] result = new String[] { "Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS" };
        assertArrayEquals( result, MexicanWave.wave("two words"),"it should return '" + Arrays.toString(result) + "'");
    }

    @Test
    public void basicTest5() {
        String[] result = new String[] { " Gap ", " gAp ", " gaP " };
        assertArrayEquals( result, MexicanWave.wave(" gap "),"it should return '" + Arrays.toString(result) + "'");
    }

}