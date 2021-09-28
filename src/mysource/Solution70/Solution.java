package mysource.Solution70;

class Solution {

    public int climbStairs_2021_250(int n) {
        int[] dpTable = new int[n+1];
        return climb(dpTable, n);
    }
    
    private int climb(int[] dpTable,  int remainSteps) {
        if (remainSteps == 0) {
            dpTable[0] = 0;
            return dpTable[0];
        }
        if (remainSteps == 1) {
            dpTable[1] = 1;
            return dpTable[1];
        }
        if (remainSteps == 2) {
            dpTable[2] = 2;
            return dpTable[2];
        }
        if (dpTable[remainSteps] != 0)
            return dpTable[remainSteps];
        dpTable[remainSteps] = climb(dpTable, remainSteps-1) + climb(dpTable, remainSteps-2);
        return dpTable[remainSteps];
    }

    public int climbStairs(int n) {
        return run2(n);
    }

    private int run2(int n) {
        if ( n == 1 ) 
            return 1;
        else if ( n == 2 ) 
            return 2;

        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 2;
        
        for(int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2]; 
        }
        return fib[n-1];
    }

    private int run(int n) {
        int count = 0;
        if ( n == 0)
            return 1;
        else if ( n < 0 ) {
            return 0;
        } else {
            count += run(n-1);
            count += run(n-2);
        }
        return count;
    }

    public int climbStairs_2021(int n) {
        int[] dp = new int[n];
        return steps(dp, n);
    }
    private int steps(int[] dp, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (dp[n-1] == 0) {
            dp[n-1] = steps(dp, n-1)+steps(dp, n-2);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(5));
        System.out.println(solution.climbStairs(6));
        System.out.println(solution.climbStairs(37));
        System.out.println(solution.climbStairs(38));
        System.out.println(solution.climbStairs(39));
        System.out.println(solution.climbStairs(40));

    }
}