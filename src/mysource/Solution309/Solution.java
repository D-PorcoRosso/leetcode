package mysource.Solution309;

class Solution {
    public int maxProfit(int[] prices) {
        if ( prices.length < 2)
            return 0;

        int[] diff = new int[prices.length - 1];
        for ( int i = 1 ; i < prices.length ; i++ ) {
            diff[i-1] = prices[i]-prices[i-1];
            System.out.println(diff[i-1]);
        }
        if ( diff.length == 1 ) {
            if ( diff[0] >= 0 )
                return diff[0];
            return 0;
        }
        int sum = 0;
        for ( int i = 2 ; i < diff.length -1 ; i++ ) {
            for ( int j = 0 ; j < i ; j++ ){
                int temp = i;
                int tempSum = 0;
                for ( int k = j ; k < diff.length ; k++ ) {
                    if ( temp == i ) {
                        tempSum += diff[k];
                    }
                    temp--;
                    if ( temp == 0 )
                        temp = i;
                }
                if ( tempSum > sum ) {
                    sum = tempSum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 1, 2, 3, 0, 2 };
        //System.out.println(solution.maxProfit(test1));
        int[] test2 = { 1,2,3,0,2,1,8,6,2,3,9 };
        //System.out.println(solution.maxProfit(test2));
        int[] test3 = { 6,5,4,3,2,1 };
        //System.out.println(solution.maxProfit(test3));
        int[] test4 = { 6,5 };
        //System.out.println(solution.maxProfit(test4));
        int[] test5 = { 6 };
        //System.out.println(solution.maxProfit(test5));
        int[] test6 = { 6,7 };
        //System.out.println(solution.maxProfit(test6));
        int[] test7 = { 1,2,2,3,8 };
        System.out.println(solution.maxProfit(test7));
    }
}