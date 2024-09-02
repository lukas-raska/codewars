package solutions.kyu4.howManyNumbersIII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HowManyNumbers_IITest {

    @Test
    public void exampleTests() {
        assertEquals(Arrays.asList(8L, 118L, 334L), HowManyNumbers_II.findAll(10, 3));
        assertEquals(Arrays.asList(1L, 999L, 999L), HowManyNumbers_II.findAll(27, 3));
        assertEquals(new ArrayList<Long>(), HowManyNumbers_II.findAll(84, 4));
        assertEquals(Arrays.asList(123L, 116999L, 566666L), HowManyNumbers_II.findAll(35, 6));
    }

    @Test
    public void notTooLargeRandomTests() {
        assertEquals(List.of(515L, 11117999L, 44555555L), HowManyNumbers_II.findAll(38, 8));
    }

    @Test
    public void largeRandomtest(){
        assertEquals(List.of(86L, 1399999L, 7777777L), HowManyNumbers_II.findAll(49, 7));
    }
}