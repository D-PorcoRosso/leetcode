package mysource.Solution279;

public class Solution {
    public int numSquares_2021_250_faster(int n) {
        int[] dpTable = new int[n+1];
        return findSquares(n, dpTable);
    }
    
    public int findSquares_faster(int n, int[] dpTable) {
        dpTable[0] = 0;
        
        for ( int i = 1 ; i <= n ; i++) {
            int j = 1;
            int min = 10000;
            while(i-j*j >=0) {
                min = Math.min(min, dpTable[i-j*j]+1);
                j++;
            }
            dpTable[i] = min;
        }
        return dpTable[n];
    }

    public int numSquares_2021_250(int n) {
        int[] dpTable = new int[n+1];
        return findSquares(n, dpTable);
    }
    
    public int findSquares(int n, int[] dpTable) {
        if (n == 0)
            return 0;
        if (dpTable[n] != 0)
            return dpTable[n];
        int min = 10000;
        for ( int i = 1 ; i <= (int)Math.sqrt(n) ; i++) {
            min = Math.min(min, 1 + findSquares(n-i*i, dpTable));
        }
        dpTable[n] = min;
        return dpTable[n];
    }
}
