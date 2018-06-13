package mysource.Solution50;

class Solution {

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