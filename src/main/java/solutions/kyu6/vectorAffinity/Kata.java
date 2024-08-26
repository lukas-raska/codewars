package solutions.kyu6.vectorAffinity;

import java.util.Arrays;

public class Kata {

    public static double vectorAffinity (int [] xs, int [] ys){
        if (Arrays.equals(xs, ys)){
            return 1;
        }
        int identicalElements = 0;
        for (int i = 0; i < Math.min(xs.length,ys.length); i++) {
            if (xs[i]==ys[i]){
                identicalElements++;
            }
        }

        return identicalElements/(double)Math.max(xs.length, ys.length);
    }
}
