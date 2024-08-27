package solutions.kyu6.whoLikesIt;

public class Solution {

    public static String whoLikesIt(String... names){
        return switch(names.length){
            case 0 -> "no one likes this";
            case 1 -> "%s likes this".formatted(names[0] );
            case 2 -> "%s and %s like this".formatted(names[0], names[1]);
            case 3 -> "%s, %s and %s like this".formatted(names[0], names[1], names [2]);
            default -> "%s, %s and %d others like this".formatted(names[0], names[1], names.length-2);
        };
    }
}
