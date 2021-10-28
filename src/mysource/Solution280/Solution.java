package mysource.Solution280;

public class Solution {
    public void wiggleSort_2021_250(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1 ; i < nums.length ; i++) {
            if (i%2==0) {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    }
}
