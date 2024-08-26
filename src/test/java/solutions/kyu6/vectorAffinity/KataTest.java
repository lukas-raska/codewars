package solutions.kyu6.vectorAffinity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {

    private final static double EPSILON = 1e-6;
    @Test
    void sampleTests() {
        assertEquals(3.0/5.0, Kata.vectorAffinity(new int[]{1,2,3,4,5},new int[]{1,2,2,4,3}), EPSILON, "vectorAffinity([1,2,3,4,5],[1,2,2,4,3])" );
        assertEquals(1.0, Kata.vectorAffinity(new int[]{1,2,3},new int[]{1,2,3}), EPSILON, "vectorAffinity([1,2,3],[1,2,3])" );
        assertEquals(3.0/5.0, Kata.vectorAffinity(new int[]{1,2,3},new int[]{1,2,3,4,5}), EPSILON, "vectorAffinity([1,2,3],[1,2,3,4,5])" );
        assertEquals(3.0/4.0, Kata.vectorAffinity(new int[]{1,2,3,4},new int[]{1,2,3,5}), EPSILON, "vectorAffinity([1,2,3,4],[1,2,3,5])" );
        assertEquals(1.0/6.0, Kata.vectorAffinity(new int[]{6,6,6,6,6,6},new int[]{6}), EPSILON, "vectorAffinity([6,6,6,6,6,6],[6])" );
        assertEquals(1.0, Kata.vectorAffinity(new int[]{},new int[]{}), EPSILON, "vectorAffinity([],[])" );
    }

}