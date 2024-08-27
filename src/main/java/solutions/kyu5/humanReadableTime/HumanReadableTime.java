package solutions.kyu5.humanReadableTime;

import java.time.Duration;


public class HumanReadableTime {

    public static String makeReadable(int seconds) {
        Duration duration = Duration.ofSeconds(seconds);
        return "%02d:%02d:%02d".formatted(duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }
}
