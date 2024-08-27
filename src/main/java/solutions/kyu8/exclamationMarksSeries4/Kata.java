package solutions.kyu8.exclamationMarksSeries4;

public class Kata {

    static String remove(String s){
        s = s.replaceAll("!","");
        return s + "!";
    }
}
