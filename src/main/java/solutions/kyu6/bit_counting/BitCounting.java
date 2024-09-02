package solutions.kyu6.bit_counting;

public class BitCounting {

    public static int countBits(int n){
        return Integer.toBinaryString(n).replaceAll("0","").length();
    }
}
