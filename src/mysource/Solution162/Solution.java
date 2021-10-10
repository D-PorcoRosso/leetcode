package mysource.Solution162;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        return findPeak(nums, 0, nums.length-1);
    }
    
    private int findPeak(int[] nums, int start, int end) {
        while(start < end) {
            int mid = (end-start)/2 + start;
            if (mid > 0 && mid < nums.length-1) {
                if (nums[mid] > nums[mid+1] && nums[mid-1] < nums[mid]) {
                    return mid;
                } else {
                    if (nums[mid+1] > nums[mid-1]) {
                        return findPeak(nums, mid+1, end);
                    } else {
                        return findPeak(nums, start, mid-1);
                    }
                }
            } else {
                if (mid == 0)
                    return nums[mid] > nums[mid+1] ? mid : mid+1;
                else 
                    return nums[mid] > nums[mid-1] ? mid : mid-1;
            }
        }
        if (start == end)
            return start;
        return -1;
    }
}
