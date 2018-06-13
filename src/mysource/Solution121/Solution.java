class Solution {
    public int maxProfit(int[] prices) {
        int diff = 0;
        if (prices == null || prices.length ==0)
            return 0;
        int min = prices[0];
        for ( int i = 1; i < prices.length; i++) {
            if ( min > prices[i] )
                min = prices[i];
            if ( diff < prices[i] - min)
                diff = prices[i] - min;
        }
        return diff;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {7,1,5,3,6,4};
        int[] test2 = {7,6,4,3,1};
        System.out.println(solution.maxProfit(test1));
        System.out.println(solution.maxProfit(test2));

    }
}