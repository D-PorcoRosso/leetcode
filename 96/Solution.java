import java.util.*;
class Solution {
    public int numTrees(int n) {
        int[] count = new int[n+1];
        count[0] = 1; count[1] = 1;
        return counting(count, n);
    }

    private int counting(int[] count, int n) {
        if ( n == 1 || n == 0 )
            return 1;
        int result = 0;
        for ( int i = 0 ; i < n ; i++ ) {
            result += (counting(count, i)*counting(count, n-1-i));
        }
        count[n] = result;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(19));
    }
}