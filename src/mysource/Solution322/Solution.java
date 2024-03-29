package mysource.Solution322;

public class Solution {

    public int coinChange_2021_250(int[] coins, int amount) {
        int[] dpTable = new int[amount+1];
        for ( int i = 0 ; i < dpTable.length ; i++ ) {
            dpTable[i] = -1;
        }
        int result = findMin(coins, dpTable, amount);
        return result == Integer.MAX_VALUE-1 ? -1 : result;
    }
    
    private int findMin(int[] coins, int[] dpTable, int amount) {
        int min = Integer.MAX_VALUE-1;
        if (amount == 0)
            return 0;
        if (amount < 0)
            return min;
        if(dpTable[amount] != -1)
            return dpTable[amount];
        for(int coin : coins) {
            int current = findMin(coins, dpTable, amount-coin);
            min = Math.min(min, 1+current);
        }
        dpTable[amount] = min;
        return min;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dpTable = new int[amount+1];
        for ( int i = 0 ; i < dpTable.length ; i++ ) 
            dpTable[i] = -2;
        return process(coins, dpTable, amount);
    }
    
    private int process(int[] coins, int[] dpTable, int amount) {
        if (amount == 0) {
            dpTable[0] = 0;
            return dpTable[amount];
        }
        if (amount < 0)
            return -1;
        if (dpTable[amount] != -2) {
            return dpTable[amount];
        }
        int min = Integer.MAX_VALUE;
        for ( int coin : coins ) {
            int temp = 1 + process(coins, dpTable, amount - coin);
            if (temp > 0) {
                if (temp < min) {
                    min = temp;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        dpTable[amount] = min;
        
        return dpTable[amount];
    }
}
