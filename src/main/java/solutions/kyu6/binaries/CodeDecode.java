package solutions.kyu6.binaries;

import java.util.Arrays;

public class CodeDecode {

    public static String code(String input) {

        StringBuilder output = new StringBuilder();

        for (char digit : input.toCharArray()) {
            int d = Character.getNumericValue(digit);
            if (d < 0) {
                throw new IllegalArgumentException();
            }
            String dBinary = Integer.toBinaryString(d);
            int length = dBinary.length();
            String key = "0".repeat(length - 1) + "1";
            output.append(key).append(dBinary);
        }

        return output.toString();
    }

    public static String decode(String string) {

        StringBuilder output = new StringBuilder();
        int index = 0;

        while (index < string.length()) {

            int keyEndsAt = string.indexOf("1", index);
            int length = keyEndsAt - index + 1;
            int binaryStartsAt = keyEndsAt + 1;
            int binaryEndsAt = binaryStartsAt + length - 1;
            String binary = string.substring(binaryStartsAt, binaryEndsAt + 1);
            output.append(Integer.parseInt(binary, 2));
            index = binaryEndsAt + 1;

        }
        return output.toString();
    }

}



