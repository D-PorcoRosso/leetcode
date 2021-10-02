package mysource.Solution96;

class Solution {

    public int numTrees_2021_250(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
    public int numTrees(int n) {
        int[] count = new int[n+1];
        count[0] = 1; count[1] = 1;
        int result = 0;
        for ( int num = 2 ; num <= n ; num++ ) {
            for ( int i = 0 ; i < num ; i++ ) {
                result += (count[i]*count[num-1-i]);
            }
            count[num] = result;
            result = 0;
        }
        return count[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(19));
    }
}