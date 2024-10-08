package solutions.kyu5.findTheSmallest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ToSmallestTest {
    private static void testing(long n, String res) {
        assertEquals(res,
                Arrays.toString(ToSmallest.smallest(n)));
    }
    @Test
    public void test() {
        System.out.println("Basic Tests smallest");
        testing(261235, "[126235, 2, 0]");
        testing(209917, "[29917, 0, 1]");
        testing(285365, "[238565, 3, 1]");
        testing(269045, "[26945, 3, 0]");
        testing(296837, "[239687, 4, 1]");

    }

//    public void randomTest(){
//        System.out.println("Random test smallest");
//        testing(87863002891L, "[18786300289, 10, 0]");
//
//    }
}