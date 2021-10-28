package mysource.Solution280;

public class Solution {
    public void wiggleSort_2021_250_fast(int[] nums) {
        for (int i = 1 ; i < nums.length ; i++) {
            if (i % 2 == 1) {
                if (nums[i] < nums[i-1])
                    swap(nums, i, i-1);
            } else {
                if (nums[i] > nums[i-1])
                    swap(nums, i, i-1);
            }
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
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
