package mysource.Solution311;

public class Solution {
    public int[][] multiply_2021_250(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];
        for (int i = 0 ; i < result.length ; i++) {
            for (int j = 0 ; j < result[0].length ; j++) {
                for (int k = 0 ; k < mat1[0].length ; k++) {
                    result[i][j] += (mat1[i][k] * mat2[k][j]);
                }
            }
        }
        return result;
    }
}
