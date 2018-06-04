import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0 ; i < n ; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 1 ; i < m ; i++) {
            matrix[i][0] = 1;
        }
        return uniquePathsWithSaver(matrix, m, n);
    }

    private int uniquePathsWithSaver(int[][] matrix, int m, int n) {
        
        if ( matrix[m-1][n-1] != 0 ) {
            System.out.println(matrix[m-1][n-1]);
            return matrix[m-1][n-1];
        }
        int result = uniquePathsWithSaver(matrix, m-1, n) + uniquePathsWithSaver(matrix, m, n-1);
        matrix[m-1][n-1] = result;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3,2));
        System.out.println(solution.uniquePaths(7,3));
        //System.out.println(solution.uniquePaths(23,12));
    }
}