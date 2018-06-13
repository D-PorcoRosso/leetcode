package mysource.Solution96;

class Solution {
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