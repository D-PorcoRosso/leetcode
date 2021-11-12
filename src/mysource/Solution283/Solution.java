package mysource.Solution283;

public class Solution {
    public void moveZeroes_2021_google(int[] nums) {
        int i = 0, j = 0;
        while(i < nums.length && j < nums.length) {
            while(i < nums.length && nums[i] != 0) {
                i++;
            }
            while(j < nums.length && nums[j] == 0) {
                j++;
            }
            if (i < j && j < nums.length && i < nums.length)
                swap(nums, i, j);
            j++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes_2021_250_fast_alittle(int[] nums) {
        int i = 0 , j = 0;
        while(i < nums.length) {
            while(nums[i] != 0) {
                i++;
                if (i == nums.length)
                    return;
            }
            j = i+1;
            while(j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j == nums.length)
                return;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
    }
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
