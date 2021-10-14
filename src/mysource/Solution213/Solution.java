package mysource.Solution213;

public class Solution {
    public int rob_2021_250(int[] nums) {
        Integer[] dpTable = new Integer[nums.length];
        boolean[] dpIsTaken = new boolean[nums.length];
        int temp = robWithIndex(nums, dpTable, dpIsTaken, 0, false);
        return temp;
    }
    
    private int robWithIndex(int[] nums, Integer[] dpTable, boolean[] dpIsTaken, int index, boolean isFirstTaken) {
        if (index == nums.length -1) {
            dpTable[index] = isFirstTaken ? 0 : nums[index];
            dpIsTaken[index] = isFirstTaken;
            return dpTable[index];
        }
        if (index == nums.length -2) {
            dpIsTaken[index] = isFirstTaken;
            if (isFirstTaken) {
                dpTable[index] = nums[index];
                return dpTable[index];
            } else {
                dpTable[index] = Math.max(nums[index],nums[index+1]);
                return dpTable[index];
            }
        }
        if (dpTable[index] != null && isFirstTaken==dpIsTaken[index]) {
            return dpTable[index];
        }
        dpIsTaken[index] = isFirstTaken;
        dpTable[index] = Math.max(robWithIndex(nums, dpTable, dpIsTaken, index+1 , isFirstTaken), nums[index]+robWithIndex(nums, dpTable, dpIsTaken, index+2 , isFirstTaken || index == 0));
        return dpTable[index];
    }
}
