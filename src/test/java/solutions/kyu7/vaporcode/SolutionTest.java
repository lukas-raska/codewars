package solutions.kyu7.vaporcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void fixedTests() {
        assertEquals("L  E  T  S  G  O  T  O  T  H  E  M  O  V  I  E  S", Solution.vaporcode("Lets go to the movies"));
        assertEquals("W  H  Y  I  S  N  T  M  Y  C  O  D  E  W  O  R  K  I  N  G", Solution.vaporcode("Why isnt my code working"));
    }
}