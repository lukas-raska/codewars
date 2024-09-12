package solutions.kyu6.data_reverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kata {

    public static int [] dataReverse (int [] data){

        List<int[]>bytes = new ArrayList<>();
        for (int i = 0; i < data.length; i+=8) {
           bytes.add(Arrays.copyOfRange(data,i, i+8));
        }

        //this works from Java 21
//        return bytes.reversed()
//                .stream()
//                .flatMapToInt(Arrays::stream)
//                .toArray();

        Collections.reverse(bytes);

        return bytes.stream().flatMapToInt(Arrays::stream).toArray();

    }



}
