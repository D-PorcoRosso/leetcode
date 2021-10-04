package mysource.Solution122;

class Solution {
    public int maxProfit_2021_250(int[] prices) {
        int max = 0;
        for ( int i = 0 ; i < prices.length ; ) {
            int j = i+1;
            if ( j < prices.length && prices[i] > prices[j] ) 
                i++;
            else{
                int localMax = 0;
                while (j < prices.length && localMax <= prices[j] - prices[i]) {
                    localMax = prices[j] - prices[i];
                    j++;
                }
                i = j;
                max += localMax;
            }
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int max = 0;
        for ( int i = length - 2 ; i >=0 ; i-- ) {
            if (prices[i+1] > prices[i]) {
                max += (prices[i+1] - prices[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {7,1,5,3,6,4};
        int[] test2 = {7,6,4,3,1};
        int[] test3 = {1,2,3,4,5};
        System.out.println(solution.maxProfit(test1));
        System.out.println(solution.maxProfit(test2));
        System.out.println(solution.maxProfit(test3));

    }
}