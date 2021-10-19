package mysource.Solution240;

public class Solution {
    public boolean searchMatrix_2021_250_faster(int[][] matrix, int target) {
        int x = 0, y = matrix.length-1;
        while(x < matrix[0].length && y >= 0) {
            if (matrix[y][x] == target)
                return true;
            else if (matrix[y][x] > target)
                y--;
            else
                x++;
        }
        return false;
    }
    public boolean searchMatrix_2021_250(int[][] matrix, int target) {
        for ( int i = 0 ; i < matrix.length ; i++ ) {
            for ( int j = 0 ; j < matrix[0].length ; j++ ) {
                if (matrix[i][j] == target)
                    return true;
                if (matrix[i][j] > target && matrix[i][0] > target) {
                    return false;
                }
            }
        }
        return false;
    }
}
