package solutions.kyu5.sports_team_table_ranking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Team implements Comparable<Team> {
    private final int id;
    private int ranking;
    private int goalsScored;
    private int scoreDifference;
    private int points;

    public Team(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getScoreDifference() {
        return scoreDifference;
    }

    public int getPoints() {
        return points;
    }

    public void updateScoredGoals(int scored) {
        this.goalsScored += scored;
    }

    public void updateScoreDifference(int scored,
                                      int conceded) {
        this.scoreDifference += scored;
        this.scoreDifference -= conceded;
    }

    public void updatePoints(int points) {
        this.points += points;
    }

    @Override
    public int compareTo(Team other) {
        return Comparator
                .comparing(Team::getPoints)
                .thenComparing(Team::getScoreDifference)
                .thenComparing(Team::getGoalsScored)
                .reversed()
                .compare(this, other);
    }
}

public class LeagueOrder {
    private final static int POINTS_FOR_WIN = 2;
    private final static int POINTS_FOR_DRAW = 1;


    public static int[] computeRanks(int number,
                                     int[][] games) {
        //creating teams mapped by Id
        Map<Integer, Team> teams = createTeams(number);

        //processing inputed games
        Arrays.stream(games).forEach(game -> processGame(teams, game));

        //computing rankings of the teams
        List<Team> sortedTeams = teams.values().stream()
                .sorted(Comparator.naturalOrder()) //natural order defined in Team class
                .toList();

        int currentRank = 1, teamsWithSameRank = 0;
        Team previous = null;

        for (Team team : sortedTeams) {
            if (previous == null) {
                team.setRanking(currentRank);
            } else {
                if (team.compareTo(previous) == 0) {
                    team.setRanking(currentRank);
                    teamsWithSameRank++;
                } else {
                    currentRank = ++currentRank + teamsWithSameRank;
                    team.setRanking(currentRank);
                    teamsWithSameRank = 0;
                }
            }
            previous = team;
        }

        return teams.values().stream()
                .sorted(Comparator.comparing(Team::getId))
                .mapToInt(Team::getRanking)
                .toArray();
    }


    private static Map<Integer, Team> createTeams(int numberOfTeams) {
        return IntStream.range(0, numberOfTeams)
                .boxed()
                .collect(Collectors.toMap(id -> id, Team::new));
    }

    private static void processGame(Map<Integer, Team> teams,
                                    int[] game) {

        Team first = teams.get(game[0]);
        Team second = teams.get(game[1]);

        first.updateScoredGoals(game[2]);
        first.updateScoreDifference(game[2], game[3]);

        second.updateScoredGoals(game[3]);
        second.updateScoreDifference(game[3], game[2]);

        boolean firstWon = game[2] > game[3];
        boolean secondWon = game[2] < game[3];

        if (firstWon) {
            first.updatePoints(POINTS_FOR_WIN);
        } else if (secondWon) {
            second.updatePoints(POINTS_FOR_WIN);
        } else {
            first.updatePoints(POINTS_FOR_DRAW);
            second.updatePoints(POINTS_FOR_DRAW);
        }
    }

}