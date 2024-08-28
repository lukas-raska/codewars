package solutions.kyu6.beginYourDayWithAChallengeButAnEasyOne;

public class Kata {


    public static String[] oneTwoThree(int n) {

        String firstPart = "";
        if (n < 10) {
            firstPart = String.valueOf(n);
        } else {
            firstPart = "9".repeat(n / 9) + ((n % 9 == 0) ? "" : n % 9);
        }
        String secondPart = (n == 0) ? "0" : "1".repeat(n);

        return new String[]{firstPart, secondPart};
    }


}
