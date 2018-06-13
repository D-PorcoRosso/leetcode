package mysource.Solution29;

class Solution {
    public int divide(int dividend, int divisor) {
        if ( dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long longdividend = dividend;
            
        boolean isNagetive = false;
        if ( longdividend < 0 && divisor > 0 ) {
            isNagetive = true;
            longdividend = 0 - longdividend;
        } else if ( longdividend > 0 && divisor < 0 ) {
            isNagetive = true;
            divisor = 0 - divisor;
        } else if ( longdividend < 0 && divisor < 0 ) {
            longdividend = 0 - longdividend;
            divisor = 0 - divisor;
        }
        int count = 0;
        while ( longdividend >= 0 ) {
            longdividend -= divisor;
            count++;
        }
        count--;
        if ( isNagetive )
            count = 0 - count;
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
        System.out.println(solution.divide(7, -1));
        System.out.println(solution.divide(-7, 2));
        System.out.println(solution.divide(-2147483648,-1));
        System.out.println(solution.divide(-2147483648,2));
        System.out.println(solution.divide(Integer.MAX_VALUE,4));
    }
}