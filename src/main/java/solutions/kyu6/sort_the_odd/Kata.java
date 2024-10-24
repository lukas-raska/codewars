package solutions.kyu6.sort_the_odd;

public class Kata {



    public static int[] sortArray(int[] array) {
        int minIndex, temp;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 != 0) {
                minIndex = i;
                for (int j = i + 1; j < array.length; j++) {

                    if (array[j] % 2 != 0) {
                        if (array[j] < array[minIndex]) {
                            minIndex = j;
                        }
                    }
                }
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

}
