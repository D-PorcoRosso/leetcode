package mysource.Solution191;

class Solution {
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