package mysource.Solution300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                if ( tails[i] < x ) {
                    i++;
                } else {
                    j--;
                }
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
