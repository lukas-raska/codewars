package solutions.kyu6.make_the_dead_fish_swim;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadFishTest {
    @Test
    public void exampleTests() {
        assertArrayEquals(new int[] {8, 64}, DeadFish.parse("iiisdoso"));
        assertArrayEquals(new int[] {8, 64, 3600}, DeadFish.parse("iiisdosodddddiso"));
    }
}