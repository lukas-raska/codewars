package solutions.kyu6.same_matrix_2x2;

import java.util.*;

public class Solution {

    static class Matrix {
        private final int[] elements;

        public Matrix(int[] elements) {
            if (elements.length != 4) {
                throw new IllegalArgumentException("Only 2x2 matrices are supported");
            }
            this.elements = elements;
        }

        private int[] rotate(int degrees,
                             int[] a) {
            return switch (degrees) {
                case 90 -> new int[]{a[2], a[0], a[3], a[1]};
                case 180 -> new int[]{a[3], a[2], a[1], a[0]};
                case 270 -> new int[]{a[1], a[3], a[0], a[2]};
                default -> throw new IllegalArgumentException("Unsupported rotation (only 90,180, or 270 degrees");
            };
        }


        @Override
        public final boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Matrix matrix)) {
                return false;
            }
            int[] a = this.elements;
            int[] b = ((Matrix) o).elements;

            return Arrays.equals(a, b) ||
                    Arrays.equals(a, rotate(90, b)) ||
                    Arrays.equals(a, rotate(180, b)) ||
                    Arrays.equals(a, rotate(270, b));


        }

        @Override
        public int hashCode() {
            int[] a = this.elements;
            int[][] allRotations = {a, rotate(90, a), rotate(180, a), rotate(270, a)};
            int [] minRotation = Arrays.stream(allRotations)
                    .min(Arrays::compare)
                    .orElse(a);
            return Arrays.hashCode(minRotation);
        }
    }


    public static int countDifferentMatrices(int[][] matrices) {

        Set<Matrix>matricesSet = new HashSet<>();
        for (int [] matrice : matrices){
            matricesSet.add(new Matrix(matrice));
        }


        return matricesSet.size();
    }


}
