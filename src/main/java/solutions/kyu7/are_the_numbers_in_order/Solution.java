package solutions.kyu7.are_the_numbers_in_order;

public class Solution {

    public static boolean isAscOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] <= arr[i]) {
                return false;
            }
        }
        return true;
    }
}
