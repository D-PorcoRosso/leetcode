package mysource.Solution1920;

public class Solution {
    public int[] buildArray_2021_amz(int[] nums) {
        int[] result = new int[nums.length];
        for ( int i = 0 ; i < nums.length ; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }
}
