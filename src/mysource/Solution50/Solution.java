package mysource.Solution50;

class Solution {

    public double myPow_2021_250(double x, int n) {

        boolean isFraction = false;
        if ( n < 0 ) {
            n = 0 - n;
            isFraction = true;
        }
        
        boolean isNagtive = false;
        if (x < 0) {
            x = 0-x;
            if (n%2 != 0) {
                isNagtive = true;
            }
        }
        if (x == 1.0) {
            if (isNagtive)
                return -1.0;
            else
                return 1.0;
        }
        
        double powResult = 1.0;
        if ( n == Integer.MIN_VALUE)
            n = Integer.MAX_VALUE;
        for ( int i = n ; i > 0 ; i-- ) {
            if (powResult < 0.00001)
                break;
            if (powResult >= 100000)
                break;
            powResult = powResult *x;
        }
        
        if (isFraction) {
            return isNagtive ? 0- 1.0/powResult : 1.0/powResult;
        }
        return isNagtive ? 0-powResult : powResult;
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if ( n < 0 ) {
            if ( n == Integer.MIN_VALUE ) {
                n = Integer.MAX_VALUE;
                if ( x < 0 )
                    x = -x;
            } else {
                n = -n;
            }
            x = 1/x;
        }
        return n % 2 == 0? myPow(x*x, n/2):x*myPow(x*x, n/2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        /*System.out.println(solution.myPow(2,10));
        System.out.println(solution.myPow(2.1,3));
        System.out.println(solution.myPow(2,-10));*/
        System.out.println(solution.myPow(0.00001,2147483647));
    }
}