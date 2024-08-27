package solutions.kyu8.exclamationMarksSeries4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    void sampleTests() {
        assertEquals("Hi!", Kata.remove("Hi!"), "For input \"Hi!\"");
        assertEquals("Hi!", Kata.remove("Hi!!!"), "For input \"Hi!!!\"");
        assertEquals("Hi!", Kata.remove("!Hi"), "For input \"!Hi\"");
        assertEquals("Hi!", Kata.remove("!Hi!"), "For input \"!Hi!\"");
        assertEquals("Hi Hi!", Kata.remove("Hi! Hi!"), "For input \"Hi! Hi!\"");
        assertEquals("Hi!", Kata.remove("Hi"), "For input \"Hi\"");
    }
}