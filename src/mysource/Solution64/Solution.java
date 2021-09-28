package mysource.Solution64;

class Solution {
    public int minPathSum_2021_250(int[][] grid) {
        int[][] dpTable = new int[grid.length][grid[0].length];
        
        return findMin(grid, dpTable, 0, 0);
    }
    
    private int findMin(int[][] grid, int[][] dpTable, int i, int j) {
        if (i == grid.length-1 && j == grid[0].length-1) {
            dpTable[i][j] = grid[i][j];
            return dpTable[i][j];
        }
        if (i == grid.length-1) {
            dpTable[i][j] = grid[i][j] + findMin(grid, dpTable, i, j+1);
            return dpTable[i][j];
        }
        
        if (j == grid[0].length-1) {
            dpTable[i][j] = grid[i][j] + findMin(grid, dpTable, i+1, j);
            return dpTable[i][j];
        }

        if (dpTable[i][j] != 0)
            return dpTable[i][j];
        
        dpTable[i][j] = grid[i][j] + Math.min(findMin(grid, dpTable, i+1, j), findMin(grid, dpTable, i, j+1));
        return dpTable[i][j];
    }

    // 原來if放在for裡面去init會比單獨init一層來得慢
    public int minPathSum(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[][] matrix = new int[m][n];
        matrix[0][0] = grid[0][0];
        for ( int i = 1 ; i < m ; i++ ) {
            matrix[i][0] = matrix[i-1][0] + grid[i][0];
        }
        for ( int j = 1 ; j < n ; j++ ) {
            matrix[0][j] = matrix[0][j-1] + grid[0][j];
        }
        for ( int i = 1 ; i < m ; i++ ) {
            for ( int j = 1 ; j < n ; j++ ) {
                matrix[i][j] = grid[i][j] + Math.min(matrix[i-1][j] , matrix[i][j-1]);
            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] test1 = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(solution.minPathSum(test1));
    }
}