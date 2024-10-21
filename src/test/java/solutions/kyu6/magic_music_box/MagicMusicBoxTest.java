package solutions.kyu6.magic_music_box;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MagicMusicBoxTest {

    @Test
    void sampleTestSimpleCase() {

        String[] expectedWords = new String[] { "DOWN", "REPTILE", "AMIDST", "SOFA" };
        String[] inputWords = new String[] { "DOWN", "REPTILE", "AMIDST", "SOFA" };

        assertEquals(Arrays.toString(expectedWords), Arrays.toString(MagicMusicBox.magicMusicBox(inputWords)),
                magicMessage(inputWords));
    }

    @Test
    void sampleTestCase() {

        String[] expectedWords = new String[] { "DOWN", "REPTILE", "AMIDST", "SOFA", "SOLAR", "PLANE", "SILENCE",
                "MARKDOWN" };
        String[] inputWords = new String[] { "DOWN", "PLANE", "AMIDST", "REPTILE", "SOFA", "SOLAR", "SILENCE", "DOWN",
                "MARKDOWN" };

        assertEquals(Arrays.toString(expectedWords), Arrays.toString(MagicMusicBox.magicMusicBox(inputWords)),
                magicMessage(inputWords));

    }

    @Test
    void emptyInputTest() {

        String[] expectedWords = new String[] {};
        String[] inputWords = new String[] {};
        assertEquals(Arrays.toString(expectedWords), Arrays.toString(MagicMusicBox.magicMusicBox(inputWords)),
                magicMessage(inputWords));

    }

    private static String magicMessage(String[] inputWords) {

        return String.format("For input: «%s» ", Arrays.toString(inputWords));

    }
}