package mysource.Solution121;

class Solution {

    public int maxProfit_2021_250_2(int[] prices) {
        int max = 0;
        for ( int i = 0 ; i < prices.length ;) {
            int j = i+1;
            while ( j < prices.length && prices[j] - prices[i] > 0 ) {
                if (prices[j] - prices[i] > max)
                    max = prices[j] - prices[i];
                j++;
            }
            i = j;
        }
        return max;
    }

    public int maxProfit_2021_250_1(int[] prices) {
        int max = 0;
        for ( int i = 0 ; i < prices.length ; i++ ) {
            for ( int j = i + 1 ; j < prices.length ; j++ )
                if (prices[j] - prices[i] > max) 
                    max = prices[j] - prices[i];
        }
        return max;
    }

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

    public int maxProfit_2021(int[] prices) {
        int max = 0;
        for ( int i = 0, j = 1 ; i < prices.length && j < prices.length ; ) {
            if ( prices[i] > prices[j] ) {
                i = j;
                j = i + 1;
            } else {
                if (max < prices[j] - prices[i]) {
                    max = prices[j] - prices[i];
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {7,1,5,3,6,4};
        int[] test2 = {7,6,4,3,1};
        System.out.println(solution.maxProfit(test1));
        System.out.println(solution.maxProfit(test2));

    }
}