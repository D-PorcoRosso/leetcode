package mysource.Solution334;

public class Solution {

    public boolean increasingTriplet_2021_250(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] <= firstNum) {
                firstNum = nums[i];
            } else if (nums[i] <= secondNum) {
                secondNum = nums[i];
            } else {
                return true;
            }
        }
        
        return false;
    }

    public boolean increasingTriplet_2021_250_TLE(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 0 ; i < nums.length ; i++) {
            if (findingIncreasing(nums, i, nums[i], 3))
                return true;
        }
        return false;
    }
    
    private boolean findingIncreasing(int[] nums, int start, int currentTarget, int count) {
        if (count == 1)
            return true;
        boolean exist = false;
        for (int i = start+1 ; i < nums.length ; i++) {
            if(currentTarget < nums[i]) {
                System.out.println("start:"+start+" count:"+count);
                exist |= findingIncreasing(nums, i, nums[i], count-1);
            }
            if(exist)
                return true;
        }
        return false;
    }
}
