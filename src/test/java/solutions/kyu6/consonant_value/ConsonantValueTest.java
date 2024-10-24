package solutions.kyu6.consonant_value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsonantValueTest {
    
    static void doTest(String input, int expected){
        assertEquals(ConsonantValue.solve(input), expected);
    }
    
    @Test
    public void basicTests() {
        doTest("zodiac", 26);
        doTest("chruschtschov", 80);
        doTest("khrushchev", 38);
        doTest("strength", 57);
        doTest("catchphrase", 73);
        doTest("twelfthstreet", 103);
        doTest("mischtschenkoana", 80);
    }
}