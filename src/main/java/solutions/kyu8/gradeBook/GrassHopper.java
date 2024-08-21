package solutions.kyu8.gradeBook;

import java.util.Arrays;

public class GrassHopper {

    public static char getGrade(int... scores) {
        double avgScore = Arrays.stream(scores)
                .average()
                .orElseThrow(IllegalArgumentException::new);

        if (avgScore <= 100 && avgScore >= 90){
            return 'A';
        }
        if (avgScore <90 && avgScore >= 80){
            return 'B';
        }
        if (avgScore <80 && avgScore >= 70){
            return 'C';
        }
        if (avgScore <70 && avgScore >= 60){
            return 'D';
        }
        return 'F';
}
}
