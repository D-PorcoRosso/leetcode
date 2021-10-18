package mysource.Solution239;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( k == 1)
            return nums;
        int[] result = new int[nums.length-k+1];
        
        for ( int i = k ; i < nums.length ; i++ ) {
            if (i-k-1 >= 0) {
                if (nums[i-k-1] < result[i-k-1])
                    result[i-k] = Math.max(result[i-k-1], nums[i-1]);
                else
                    result[i-k] = findMax(nums, i-k, i);
            } else {
                result[i-k] = findMax(nums, i-k, i);
            }
        }
        result[nums.length-k] = findMax(nums, nums.length-k, nums.length);
        return result;
    }
    
    private int findMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for ( int i = start ; i < end ; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
