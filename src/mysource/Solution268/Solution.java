package mysource.Solution268;

public class Solution {
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
