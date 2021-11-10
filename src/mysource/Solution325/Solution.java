package mysource.Solution325;

public class Solution {
    public int maxSubArrayLen_2021_250_TLE(int[] nums, int k) {
        int maxLength = 0;
        for ( int i = 0 ; i < nums.length ; i++) {
            int sum = nums[i];
            if(sum == k)
                maxLength = Math.max(maxLength, 1);
            for ( int j = i+1 ; j < nums.length ; j++) {
                sum += nums[j];
                if(sum == k)
                    maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }
}
