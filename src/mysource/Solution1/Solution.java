import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = { 0, 0};
        for ( int i = 0 ; i < nums.length ; i++ ) {
            for ( int j = i + 1 ; j < nums.length ; j++) {
                if ( nums[i] + nums[j] == target ) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,11,15,9};

        int target = 17;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}