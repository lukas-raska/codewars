package solutions.kyu5.sports_team_table_ranking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Team implements Comparable<Team> {

    private final int id;
    private int ranking;
    private int goalsScored;
    private int goalsConceded;
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
        this.scoreDifference = goalsScored - goalsConceded;

    }

    public void updateConcededGoals(int conceded) {
        this.goalsConceded += conceded;
        this.scoreDifference = goalsScored - goalsConceded;
    }

    public void updatePoints(int points) {
        this.points += points;
    }

    @Override
    public int compareTo(Team other) {
        return Comparator
                .comparing(Team::getPoints, Comparator.reverseOrder())
                .thenComparing(Team::getScoreDifference, Comparator.reverseOrder())
                .thenComparing(Team::getGoalsScored, Comparator.reverseOrder())
                .compare(this, other);
    }
}

public class LeagueOrder {

    private final List<Team> teams = new ArrayList<>();
    private final static int POINTS_FOR_WIN = 2;
    private final static int POINTS_FOR_DRAW = 1;


    public static int[] computeRanks(int number,
                                     int[][] games) {
        //crating teams
        List<Team> teams = createTeams(number);

        //processing inputed games
        Arrays.stream(games).forEach(game -> processGame(teams, game));

        //sorting teams by given rules
        teams.sort(Comparator.naturalOrder());

        //computing ranking of the teams
        int currentRank = 1, teamsWithSameRank = 0;
        Team previous = null;
        for (Team team : teams) {

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

        return teams.stream()
                .sorted(Comparator.comparing(Team::getId))
                .mapToInt(Team::getRanking)
                .toArray();
    }


    private static List<Team> createTeams(int numberOfTeams) {
        return IntStream.range(0, numberOfTeams)
                .mapToObj(Team::new)
                .collect(Collectors.toList());
    }

    private static void processGame(List<Team> teams,
                                    int[] game) {

        Team first = findById(teams, game[0]);
        Team second = findById(teams, game[1]);

        first.updateScoredGoals(game[2]);
        first.updateConcededGoals(game[3]);

        second.updateScoredGoals(game[3]);
        second.updateConcededGoals(game[2]);

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

    private static Team findById(List<Team> teams,
                                 int id) {
        return teams.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElseThrow();
    }

}