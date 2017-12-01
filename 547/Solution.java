import java.lang.Math.*;

public class Solution {
    public int findCircleNum(int[][]M) {
        int n = M[0].length;
        int[] sum = new int[n];

        for ( int round = 1 ; round < n ; round++ ) {

            for ( int i = 0 ; i < n ; i++ ) {
                for ( int j = 0 ; j < n ; j++ ) {
                    sum[j] += M[i][j];
                }
            }
        }

        int[] sizeN = new int[n];
        for ( int i= 0 ; i < n ; i++ )
            sizeN[i] = n;

        for ( int j = 1 ; j < n ; j++ ) {
            for ( int i = 0 ; i < n ; i++ ) {
                sizeN[i] -= sum[i];

                if ( sizeN[i] <= 0 )
                    return j;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = { {1,1,0}, {1,1,1}, {0,1,1} };
        //System.out.println(solution.findCircleNum(test));

        int[][] test2 = { {1,1,0}, {1,1,0}, {0,0,1} };
        System.out.println(solution.findCircleNum(test2));

        int[][] test3 = { {1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1} };
        System.out.println(solution.findCircleNum(test3));
    }
}