package mysource.Solution63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ( obstacleGrid[0][0] == 1 )
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        for ( int i = 0 ; i < m ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                if ( i == 0 || j == 0 ) {
                    if ( obstacleGrid[i][j] == 1) {
                        matrix[i][j] = 0;
                        if ( i == 0 && (j+1) < n )
                            obstacleGrid[i][j+1] = 1;
                        if ( j == 0 && (i+1) < m )
                            obstacleGrid[i+1][j] = 1;
                    } else matrix[i][j] = 1;
                } else {
                    if ( obstacleGrid[i][j] == 1 ) matrix[i][j] = 0;
                    else matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(solution.uniquePathsWithObstacles(test1));
        int[][] test2 = {{1}};
        System.out.println(solution.uniquePathsWithObstacles(test2));
        int[][] test3 = {{1,0}};
        System.out.println(solution.uniquePathsWithObstacles(test3));
        int[][] test4 = {{0,1,0}};
        System.out.println(solution.uniquePathsWithObstacles(test4));
        int[][] test5 = {
            {0,0},
            {1,0}           
        };
        System.out.println(solution.uniquePathsWithObstacles(test5));
    }
}