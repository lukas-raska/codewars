package solutions.kyu5.mergedStringChecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMergerTest {
    @Test
    public void normalHappyFlow() {
        assertTrue(StringMerger.isMerge("codewars", "code", "wars"), "codewars can be created from code and wars");
        assertTrue(StringMerger.isMerge("codewars", "cdwr", "oeas"), "codewars can be created from cdwr and oeas");
        assertFalse(StringMerger.isMerge("codewars", "cod", "wars"), "Codewars are not codwars");
    }

    @Test
    public void someRandomCases() {
        assertTrue(StringMerger.isMerge("Can we merge it? Yes, we can!", "a gisw cn", "Cn wemere t? Ye, ea!"));
        assertTrue(StringMerger.isMerge("yR'uuuU+>^", "y'uU>", "Ruu+^"));
        assertTrue(StringMerger.isMerge("aaaa", "aa", "aa"));
    }

}