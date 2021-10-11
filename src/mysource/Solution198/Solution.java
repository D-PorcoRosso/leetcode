package mysource.Solution198;

public class Solution {

    public int rob_2021_250(int[] nums) {
        Integer[] dpTable = new Integer[nums.length];
        return tryRob(nums, dpTable, 0);
    }
    
    private int tryRob(int[] nums, Integer[] dpTable, int start) {
        if (start == nums.length-1) {
            dpTable[start] = nums[start];
            return dpTable[start];
        }
        
        if (start == nums.length-2) {
            dpTable[start] = nums[start] > nums[start+1] ? nums[start] : nums[start+1];
            return dpTable[start];
        }
        
        if (dpTable[start] != null)
            return dpTable[start];
        
        dpTable[start] = Math.max(nums[start] + tryRob(nums, dpTable, start+2), tryRob(nums, dpTable, start+1));
        return dpTable[start];
    }

    public int rob(int[] nums) {
        int[] dpTable = new int[nums.length];
        for (int i = 0 ; i < dpTable.length ; i++)
            dpTable[i] = -1;
        return getLocalMax(nums, dpTable, 0);
    }
    
    private int getLocalMax(int[] nums, int[] dpTable, int currentIndex) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        if (dpTable[currentIndex] != -1) {
            return dpTable[currentIndex];
        }
        
        if (currentIndex == nums.length - 2) {
            dpTable[currentIndex] = Math.max(nums[nums.length-2], nums[nums.length-1]);
            return dpTable[currentIndex];
        }
        if (currentIndex == nums.length - 1) {
            dpTable[currentIndex] = nums[nums.length-1];
            return dpTable[currentIndex];
        }
        dpTable[currentIndex] = Math.max(nums[currentIndex] + getLocalMax(nums, dpTable, currentIndex+2), getLocalMax(nums, dpTable, currentIndex+1));
        return dpTable[currentIndex];
    }
}
