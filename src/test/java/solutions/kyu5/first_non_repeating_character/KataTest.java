package solutions.kyu5.first_non_repeating_character;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    @DisplayName("Sample tests")
    void sampleTests() {
        assertEquals("a", Kata.firstNonRepeatingLetter("a"), "For input \"a\"");
        assertEquals("t", Kata.firstNonRepeatingLetter("streSS"), "For input \"streSS\"");
        assertEquals("-", Kata.firstNonRepeatingLetter("moon-men"), "For input \"moon-men\"");
        assertEquals("", Kata.firstNonRepeatingLetter("moonmoon"), "For input \"moonmoon\"");
    }

    @Test
    @DisplayName("Letter case tests")
    void letterCaseTests(){
        assertEquals("L", Kata.firstNonRepeatingLetter("I Like To Take Candy From A Baby"), "For input \"I Like To Take Candy From A Baby\"");
    }


}