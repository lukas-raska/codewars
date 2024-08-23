package solutions.kyu8.quadrants;

public class Kata {

    public static int quadrant(int x, int y){
        if (x == 0 || y == 0){
            throw new IllegalArgumentException("Quadrant for coordinates [%d,%d] cannot be determined".formatted(x,y));
        }
        if (x > 0){
            return (y>0)? 1:4;
        }
        return (y>0)? 2:3;
    }
}
