package solutions.kyu4.a_simplistic_TCP_finite_state_machine;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TCP {

    private record Tranformation(String initialState,
                                 String event,
                                 String finalState) {

    }

    private static final String INITIAL_STATE = "CLOSED";
    private static final String ERROR_STATE = "ERROR";

    private static final String DATA = """
            CLOSED: APP_PASSIVE_OPEN -> LISTEN
            CLOSED: APP_ACTIVE_OPEN  -> SYN_SENT
            LISTEN: RCV_SYN          -> SYN_RCVD
            LISTEN: APP_SEND         -> SYN_SENT
            LISTEN: APP_CLOSE        -> CLOSED
            SYN_RCVD: APP_CLOSE      -> FIN_WAIT_1
            SYN_RCVD: RCV_ACK        -> ESTABLISHED
            SYN_SENT: RCV_SYN        -> SYN_RCVD
            SYN_SENT: RCV_SYN_ACK    -> ESTABLISHED
            SYN_SENT: APP_CLOSE      -> CLOSED
            ESTABLISHED: APP_CLOSE   -> FIN_WAIT_1
            ESTABLISHED: RCV_FIN     -> CLOSE_WAIT
            FIN_WAIT_1: RCV_FIN      -> CLOSING
            FIN_WAIT_1: RCV_FIN_ACK  -> TIME_WAIT
            FIN_WAIT_1: RCV_ACK      -> FIN_WAIT_2
            CLOSING: RCV_ACK         -> TIME_WAIT
            FIN_WAIT_2: RCV_FIN      -> TIME_WAIT
            TIME_WAIT: APP_TIMEOUT   -> CLOSED
            CLOSE_WAIT: APP_CLOSE    -> LAST_ACK
            LAST_ACK: RCV_ACK        -> CLOSED""";

    private static final List<Tranformation> rules = getRules();


    public static String traverseStates(String[] events) {

        String currentState = INITIAL_STATE;

        for (String event : events) {
            String finalCurrentState = currentState;
            currentState = rules.stream()
                    .filter(t -> t.initialState().equals(finalCurrentState))
                    .filter(t -> t.event().equals(event))
                    .map(t -> t.finalState)
                    .findAny()
                    .orElse(ERROR_STATE);

        }
        return currentState;
    }


    private static List<Tranformation> getRules() {
        Scanner scanner = new Scanner(TCP.DATA);
        List<Tranformation> rules = new ArrayList<>();
        Pattern dataPattern = Pattern.compile("(.*):(.*)->(.*)");

        while (scanner.hasNextLine()) {

            Matcher matcher = dataPattern.matcher(scanner.nextLine());

            if (matcher.matches()){
                String initialState = matcher.group(1).trim();
                String event = matcher.group(2).trim();
                String finalState = matcher.group(3).trim();
                rules.add(new Tranformation(initialState, event, finalState));
            }
        }
        scanner.close();

        return rules;
    }
}
