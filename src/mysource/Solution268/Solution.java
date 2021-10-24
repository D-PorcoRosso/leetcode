package mysource.Solution268;

public class Solution {
    public int missingNumber_2021_250(int[] nums) {
        
        int sum = (nums.length)*(nums.length+1)/2;
        int target = 0;
        boolean isExistZero = false;
        for (int n : nums) {
            if (n == 0)
                isExistZero = true;
            target += n;
        }
        if (target == sum) {
            return isExistZero ? nums.length : 0;
        }
        return sum-target;
    }

    public int missingNumber(int[] nums) {
        int[] container = new int[nums.length+1];
        for ( int i = 0 ; i < nums.length ; i++ ) {
            container[nums[i]] = 1;
        }
        
        for ( int i = 0 ; i < container.length ; i++ ) {
            if (container[i] == 0)
                return i;
        }
        return -1;
    }

    public int missingNumber_o1(int[] nums) {
        int totalSum = (nums.length+1)*nums.length/2;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            totalSum -= nums[i];
        }
        return totalSum;
    }
}
