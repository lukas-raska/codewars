package solutions.kyu7.numberToDigitTiers;

public class Solution {

    public static String[] createArrayOfTiers(int num) {
        String numAsString = String.valueOf(num);
        String[] output = new String[numAsString.length()];
        for (int i = 0; i < output.length; i++) {
            output[i]=numAsString.substring(0,i+1);
        }
        return output;
    }
}
