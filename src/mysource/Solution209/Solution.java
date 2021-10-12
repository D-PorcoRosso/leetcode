package mysource.Solution209;

public class Solution {
    public int minSubArrayLen_2021_250(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }
        int min = Integer.MAX_VALUE, i = 0 , j = i+1;
        int sum = nums[i], count = 1;
        while (j < nums.length) {
            while(sum < target && j < nums.length) {
                sum += nums[j];
                j++;
                count++;
            }
            if (sum < target && j == nums.length) {
                if (min == Integer.MAX_VALUE)
                    min = Math.min(min, 0);
                break;
            }
            while(sum >= target && i <= j) {
                if (sum >= target){
                    min = Math.min(min, count);
                }
                sum -= nums[i];
                count--;
                i++;
            }
        }
        return min;
    }
}
