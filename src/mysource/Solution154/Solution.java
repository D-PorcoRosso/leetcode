package mysource.Solution154;

public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1, min = Integer.MAX_VALUE;
        while(start <= end) {
            min = Math.min(nums[start], Math.min(min, nums[end]));
            ++start;
            --end;
        }
        return min;
    }
}
