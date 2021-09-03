package mysource.Solution62;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for ( int i = 0 ; i < m ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                if ( i == 0 || j == 0 ) matrix[i][j] = 1;
                else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[m-1][n-1];
    }

    public int uniquePaths_2021(int m, int n) {
        int[][] dp = new int[m][n];
        for( int i = 0 ; i < m ; i++ ) {
            dp[i][0] = 1;
        }
        for( int i = 0 ; i < n ; i++ ) {
            dp[0][i] = 1;
        }
        return findingPaths(dp, m, n);
    }
    private int findingPaths(int[][] dp, int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        if (dp[m-1][n-1] == 0) {
            dp[m-1][n-1] = findingPaths(dp, m, n-1)+findingPaths(dp, m-1,n);
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3,2));
        System.out.println(solution.uniquePaths(7,3));
        //System.out.println(solution.uniquePaths(23,12));
    }
}