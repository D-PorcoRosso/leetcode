package mysource.Solution283;

public class Solution {
    public void moveZeroes_2021_250(int[] nums) {
        for ( int i = nums.length-1 ; i >= 0 ; i--) {
            if (nums[i] == 0) {
                int j = i;
                while(j+1 < nums.length) {
                    if (nums[j+1] == 0)
                        break;
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
        }
    }
}
