package mysource.Solution324;

public class Solution {
    public void wiggleSort_2021_250(int[] nums) {
        Arrays.sort(nums);
        int[] sorted = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            sorted[i] = nums[i];
        }
        int smallIndex = (nums.length+1)/2-1, largeIndex = nums.length-1;
        for (int i = 0 ; i < nums.length ; i++ ) {
            if(i%2 == 0) {
                nums[i] = sorted[smallIndex];
                smallIndex--;
            } else {
                nums[i] = sorted[largeIndex];
                largeIndex--;
            }
        }
    }
}
