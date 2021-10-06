package mysource.Solution153;

public class Solution {
    public int findMin_2021_250(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int start = 0, end = nums.length-1, mid = 0;
        while (start <= end) {
            mid = (end-start)/2 + start;
            if (start == end) break;
            if (nums[mid] > nums[mid+1])
                return nums[mid+1];
            if (mid-1 >= 0 && nums[mid] < nums[mid-1])
                return nums[mid];
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return nums[start];
    }

    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int left = 0, right = nums.length-1;
        
        if (nums[right] > nums[0])
            return nums[0];
        
        while( left <= right ) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[mid+1])
                return nums[mid+1];
            
            if (nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            
            if (nums[mid] > nums[0])
                left = mid + 1;
            else
                right = mid -1;
        }
        return -1;
    }
}
