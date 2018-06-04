import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        if ( m == 1 || n == 1 ) return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3,2));
        System.out.println(solution.uniquePaths(7,3));
    }
}