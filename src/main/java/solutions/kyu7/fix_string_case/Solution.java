package solutions.kyu7.fix_string_case;

public class Solution {

    public static String solve(String str) {
        int upperCount = 0;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }
        boolean hasMoreUppers = upperCount > str.length()-upperCount;
        return (hasMoreUppers) ? str.toUpperCase() : str.toLowerCase();
    }
}
