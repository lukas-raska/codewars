package solutions.kyu8.howMuchILoveYou;

public class Sid {


    public static String howMuchILoveYou(int nb_petals) {
        final String[] phrases = {"I love you", "a little", "a lot", "passionately", "madly", "not at all"};
        return phrases[(nb_petals - 1) % phrases.length];
    }
}
