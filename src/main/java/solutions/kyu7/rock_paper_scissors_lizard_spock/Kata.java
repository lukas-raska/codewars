package solutions.kyu7.rock_paper_scissors_lizard_spock;

import java.util.List;
import java.util.Map;

public class Kata {

    public static String rpsls(String player1,
                               String player2) {
        Map<String, List<String>> defeatsMap = Map.of(
                "scissors", List.of("paper", "lizard"), //scissors cuts paper and decapitates lizard
                "paper", List.of("rock", "spock"), //paper covers rock and disproves Spock
                "rock", List.of("lizard", "scissors"), //rock crushes scissors and lizard
                "lizard", List.of("spock", "paper"), //lizard poisons Spock and eats paper
                "spock", List.of("scissors", "rock") //spock vaporizes rock and smashes scissors
        );
        if (!defeatsMap.containsKey(player1) || !defeatsMap.containsKey(player2)) {
            throw new IllegalArgumentException("Unknown player move (#1: " + player1 + ", #2: " + player2 + ")");
        }

        if (defeatsMap.get(player1).contains(player2)) {
            return "Player 1 Won!";
        }

        if (defeatsMap.get(player2).contains(player1)) {
            return "Player 2 Won!";
        }
        return "Draw!";
    }
}
