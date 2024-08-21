package solutions.kyu8.howMuchILoveYou;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SidTest {

    @Test
    public void test1() {
        assertEquals("I love you", Sid.howMuchILoveYou(1));
        assertEquals("a little", Sid.howMuchILoveYou(2));
        assertEquals("not at all", Sid.howMuchILoveYou(6));
    }

}