package solutions.kyu6.what_century_is_it;

public class Solution {



    public static String whatCentury(int year) {

        int century = (year / 100) + (year % 100 == 0 ? 0 : 1);
        int lastDigit = century % 10;
        String suffix = switch (lastDigit){
            case 1 -> (century != 11)? "st":"th";
            case 2 -> (century != 12)? "nd":"th";
            case 3 -> (century != 13)? "rd":"th";
            default -> "th";
        };

        return  century + suffix;
    }

}
