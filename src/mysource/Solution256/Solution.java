package mysource.Solution256;

public class Solution {
    public int minCost_2021_250(int[][] costs) {
        int[][] dpTable = new int[costs.length][costs[0].length];
        return findMin(costs, dpTable, 0, -1);
    }
    
    private int findMin(int[][] costs, int[][] dpTable, int currentHouse, int currentColor) {
        int localMin = 20000;
        if (currentHouse == costs.length)
            return 0;
        if (currentColor != -1 && dpTable[currentHouse][currentColor] != 0)
            return dpTable[currentHouse][currentColor];
        for ( int j = 0 ; j < costs[0].length ; j++ ) {
            if (j == currentColor)
                continue;
            else {
                localMin = Math.min(localMin, costs[currentHouse][j]+findMin(costs, dpTable, currentHouse+1, j));
            }
        }
        if (currentColor != -1)
            dpTable[currentHouse][currentColor] = localMin;
        return localMin;
    }
}
