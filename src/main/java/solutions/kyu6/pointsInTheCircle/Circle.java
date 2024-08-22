package solutions.kyu6.pointsInTheCircle;

public class Circle {

    public static int pointsNumber(int radius) {
        int count = 0;
        for (int x = -1*radius; x <= radius; x++){
            for (int y = radius; y>= -1* radius; y--){
                if (isInTheCircle(x,y,radius)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isInTheCircle(int x,
                                         int y,
                                         int radius) {
        return x * x + y * y <= radius * radius;
    }
}
