import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            for ( int j = 0 ; j < length ; j++ ) {
                for ( int k = 0 ; k < length ; k++ ) {
                    if ( k != j && k != i && i != j ) {
                        if ( (nums[i] + nums[j] + nums[k]) == 0 ) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            Collections.sort(temp);
                            if ( !result.contains(temp) ) {
                                result.add(temp);
                            }
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
        System.out.println(solution.threeSum(test1));
        int[] test2 = {-1, 1, 8, -1, -4};
        System.out.println(solution.threeSum(test2));
    }
}