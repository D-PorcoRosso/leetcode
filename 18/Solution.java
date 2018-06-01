import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            for ( int j = i + 1 ; j < length ; j++ ) {
                for ( int k = j + 1 ; k < length ; k++ ) {
                    for ( int l = k + 1 ; l < length ; l++ ) {
                        if ( nums[i] + nums[j] + nums[k] + nums[l] == target ) {
                            List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            if (!result.contains(temp))                        
                                result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        //System.out.println(solution.threeSum(test1));
        int[] test2 = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> t = solution.fourSum(test2,0);
        System.out.println(t.size());
        System.out.println(t);
    }
}