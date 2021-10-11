package mysource.Solution191;

class Solution {

    public int hammingWeight_2021_250(int n) {
        int count = 0;
        if (n < 0) {
            n = Integer.MAX_VALUE+n+1;
            count = 1;
        }
        while(n != 0) {
            if (n%2 == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        double target;
        if ( n < 0 ) {
            target = Integer.MAX_VALUE + 1 + n;
            count = 1;
        } else 
            target = n;
        int index = 32;
        while( index > 0 ) {
            double current = Math.pow(2,index-1);
            if ( (target/current) >= 1.0 ) {
                target -= current;
                count++;
            }
            index--;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.hammingWeight(2147483648));

    }
}