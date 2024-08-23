package solutions.kyu8.indexOfAnElementInAnArray;


import java.util.List;

public class Solution {

    public static String kata(String[] array,
                              String str) {
        int i = List.of(array).indexOf(str);
        return (i < 0) ? "Not found" : "" + i;
    }
}
