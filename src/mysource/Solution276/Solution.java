package mysource.Solution276;

public class Solution {
    public int numWays_2021_250(int n, int k) {
        int one = k;
        int sec = k*k;
        if (n == 1) {
            return one;
        }
        if (n == 2)
            return sec;
        for (int i = 3 ; i <= n ; i++) {
            int curr = (k-1)*(one+sec);
            one = sec;
            sec = curr;
        }
        return sec;
    }
}
