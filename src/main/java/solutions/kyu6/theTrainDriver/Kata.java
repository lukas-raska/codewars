package solutions.kyu6.theTrainDriver;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Kata {

    record Route(String origin,
                 String destination,
                 int standByTime,
                 double tripDuration) {
    }

    private static final List<Route> ROUTES_DATA = List.of(
            new Route("Skyport", "Crystalium", 15, 2),
            new Route("Crystalium", "Skyport", 10, 2),
            new Route("Skyport", "Oasis", 20, 3),
            new Route("Oasis", "Skyport", 15, 3),
            new Route("Oasis", "Crystalium", 15, 1.5),
            new Route("Crystalium", "Oasis", 10, 1.5),
            new Route("Skyport", "Nexus", 15, 4),
            new Route("Nexus", "Skyport", 10, 4)
    );

    private final static String STARTING_PLACE = "Skyport";

    public static String arrivalTime(final String[] routes,
                                     final String departureTime) {
        if (routes.length == 0) {
            return "The Train Driver has the day off";
        }

        double elapsedTime = 0;
        int routeIndex = 0;
        String currentPlace = STARTING_PLACE;
        String nextPlace = routes[routeIndex];

        boolean isJourneyFinished = false;
        boolean isRouteFound = false;

        while (!isJourneyFinished) {

            Route currentRoute = null;
            //pokud se příští místo shoduje s aktuálním umístěním, čekám hodinu a posunu na další místo
            if (nextPlace.equals(currentPlace)) {
                elapsedTime += 1;
                routeIndex++;
                continue;
            }
            //najdu cestu z výchozího, či aktuálního umístění
            Optional<Route> optionalRoute = findRoute(currentPlace, nextPlace);
            if (optionalRoute.isPresent()) {
                currentRoute = optionalRoute.get();
                currentPlace = nextPlace;

                if (routeIndex < routes.length-1) {
                    nextPlace = routes[++routeIndex];

                } else {
                    isJourneyFinished = true;
                                    }
            } else {
                currentRoute = findRoute(currentPlace, STARTING_PLACE)
                        .orElseThrow(() -> new IllegalArgumentException("Route for %s -> %s not found, check routes " +
                                "data."));
                currentPlace = STARTING_PLACE;
                nextPlace = routes[routeIndex];
            }



            elapsedTime += currentRoute.standByTime() / 60.0 + currentRoute.tripDuration();


        }

        return updateTime(departureTime, elapsedTime);
    }


    private static Optional<Route> findRoute(String origin,
                                             String destination) {
        return ROUTES_DATA.stream()
                .filter(route -> route.origin().equals(origin) && route.destination().equals(destination))
                .findFirst();

    }

    private static String updateTime(String departureTime,
                                     double elapsedTime) {
        if (!departureTime.matches("[0-9]{2}:[0-9]{2}")){
            throw new IllegalArgumentException("Wrong format od departure time: " + departureTime);
        }
        int hours = (int) elapsedTime;
        int minutes = (int) ((elapsedTime - hours) * 60);
        return LocalTime.parse(departureTime).plusHours(hours).plusMinutes(minutes).toString();
    }


}
