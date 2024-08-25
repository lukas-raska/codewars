package solutions.kyu6.theTrainDriver;

import java.time.LocalTime;
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

        int elapsedTime = 0; //in minutes
        int routeIndex = 0;
        String currentPlace = STARTING_PLACE;
        String nextPlace = routes[routeIndex];

        while (routeIndex < routes.length) {

            //pokud se příští místo shoduje s aktuálním umístěním, čekám hodinu a posunu na další místo
            if (nextPlace.equals(currentPlace)) {
                elapsedTime += 60;
                routeIndex++;
                if (routeIndex < routes.length) {
                    nextPlace = routes[routeIndex];
                }
                continue;
            }

            //najdu cestu z výchozího, či aktuálního umístění
            Optional<Route> optionalRoute = findRoute(currentPlace, nextPlace);
            Route currentRoute;

            if (optionalRoute.isPresent()) {
                currentRoute = optionalRoute.get();
                currentPlace = nextPlace;
                routeIndex++;
                if (routeIndex < routes.length) {
                    nextPlace = routes[routeIndex];
                }
            } else {
                currentRoute = findRoute(currentPlace, STARTING_PLACE)
                        .orElseThrow(IllegalArgumentException::new);
                currentPlace = STARTING_PLACE;
            }

            elapsedTime += (int) (currentRoute.tripDuration()*60 + currentRoute.standByTime());

        }

        return LocalTime.parse(departureTime).plusMinutes(elapsedTime).toString();
    }


    private static Optional<Route> findRoute(String origin,
                                             String destination) {
        return ROUTES_DATA.stream()
                .filter(route -> route.origin().equals(origin) && route.destination().equals(destination))
                .findFirst();

    }


}



