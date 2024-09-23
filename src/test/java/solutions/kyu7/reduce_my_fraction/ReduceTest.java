package solutions.kyu7.reduce_my_fraction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReduceTest {
    @ParameterizedTest(name = "Fraction = '{'{2}, {3}'}'")
    @DisplayName("Sample test cases")
    @CsvSource({
            "   3, 1,     60,  20",
            "   2, 3,     80, 120",
            "   2, 1,      4,   2",
            "   3, 8,     45, 120",
            "1000, 1,   1000,   1",
            "   1, 1,      1,   1"
    })
    void exampleTests(int expectedNumerator, int expectedDenominator, int nominator, int denominator){
        assertArrayEquals(new int[]{expectedNumerator, expectedDenominator}, Reduce.myFraction(new int[]{nominator, denominator}));
    }
}