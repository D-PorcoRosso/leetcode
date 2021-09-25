package mysource.Solution45;

public class Solution {
    public int jump(int[] nums) {
        int[] dpTable = new int[nums.length];
        for (int i = 0 ; i < dpTable.length ; i++) {
            dpTable[i] = -1;
        }
        return findMin(nums, dpTable, 0);
    }
    
    private int findMin(int[] nums, int[] dpTable, int index) {
        if (index >= nums.length - 1)
            return 0;
        
        if (nums[index] == 0)
            return 500000;
        
        if (dpTable[index] != -1) {
            return dpTable[index];
        }
        
        int min = Integer.MAX_VALUE, minStep = 0;
        for ( int i = 1 ; i <= nums[index] ; i++ ) {
            int currentStep = 1+findMin(nums, dpTable, index + i);
            if (min > currentStep) {
                min = currentStep;
                minStep = i;
            }
        }
        dpTable[index] = min;
        
        return dpTable[index];
    }
}
