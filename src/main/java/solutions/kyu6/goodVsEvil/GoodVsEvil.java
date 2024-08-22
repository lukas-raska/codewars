package solutions.kyu6.goodVsEvil;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class GoodVsEvil {

    private enum GoodBeings {
        Hobbits(1), Men(2), Elves(3), Dwarves(3), Eagles (4), Wizards(10);

        private final int worth;

        GoodBeings(int worth) {
            this.worth = worth;
        }
    }

    private enum EvilCreatures {
        Orcs(1), Men(2), Wargs(2), Goblins(2), UrukHai(3), Trolls (5), Wizards(10);

        private final int worth;

        EvilCreatures(int worth) {
            this.worth = worth;
        }
    }

    public static String battle(String goodAmounts,
                                         String evilAmounts) {


        var goodAmountsArr = modifyInput(goodAmounts);
        var evilAmountsArr = modifyInput(evilAmounts);

        if (goodAmountsArr.length != GoodBeings.values().length || evilAmountsArr.length != EvilCreatures.values().length) {
            throw new IllegalArgumentException("Wrong input");
        }

        int goodScore = 0;
        int evilScore = 0;

        for (int i = 0; i < goodAmountsArr.length; i++) {
            goodScore += goodAmountsArr[i] * GoodBeings.values()[i].worth;
        }
        for (int i = 0; i < evilAmountsArr.length; i++) {
            evilScore += evilAmountsArr[i] * EvilCreatures.values()[i].worth;
        }

        System.out.println("Good score = " + goodScore);
        System.out.println("Evil score = " + evilScore);

        if (goodScore > evilScore){
            return "Battle Result: Good triumphs over Evil";
        }
        if (goodScore < evilScore) {
            return "Battle Result: Evil eradicates all trace of Good";
        }
        return "Battle Result: No victor on this battle field";


    }

    private static int [] modifyInput (String amounts){
        return Arrays.stream(amounts.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
