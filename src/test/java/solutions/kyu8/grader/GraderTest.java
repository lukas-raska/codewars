package solutions.kyu8.grader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

    @Test
    void sampleTests(){
        assertEquals("C", Grader.grader(0.7));
        assertEquals("A", Grader.grader(0.9));
        assertEquals("D", Grader.grader(0.6));
        assertEquals("F", Grader.grader(1.1), "1.1 is greater than 1 the grade should be \"F\"");
    }

}