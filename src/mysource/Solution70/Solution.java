package mysource.Solution70;

class Solution {
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