package solutions.kyu5.help_your_granny;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class Tour {

    public static int tour(String[] friends,
                           String[][] friendsTowns,
                           Map<String, Double> distances) {

        double totalDistance = 0;
        String start = "", end = "";
        boolean isFirst = true;


        for (int i = 0; i < friends.length - 1; i++) {

            Optional<String> currentTown = getFriendTown(friends[i], friendsTowns);
            Optional<String> nextTown = getFriendTown(friends[i + 1], friendsTowns);

            if (currentTown.isPresent() && nextTown.isPresent()) {

                start = currentTown.get();
                end = nextTown.get();

                if (isFirst) {
                    totalDistance += distances.get(start);
                    isFirst = false;
                }

                totalDistance += countDistancesBetweenTowns(start, end, distances);
            }



        }

        //distance back to home
        totalDistance+=distances.get(end);

        return (int) totalDistance;
    }

    private static Optional<String> getFriendTown(String friend,
                                                  String[][] friendsTowns) {
        return Arrays.stream(friendsTowns)
                .filter(pair -> pair[0].equals(friend))
                .map(pair -> pair[1])
                .findFirst();
    }

    private static double countDistancesBetweenTowns(String town1,
                                                     String town2,
                                                     Map<String, Double> distances) {
        double distTown1 = distances.get(town1);
        double distTown2 = distances.get(town2);
        if (distTown1 == distTown2) {
            return 0;
        }
        double longer = Math.max(distTown1, distTown2);
        double shorter = Math.min(distTown1, distTown2);

        return Math.sqrt(longer * longer - shorter * shorter);
    }


}



