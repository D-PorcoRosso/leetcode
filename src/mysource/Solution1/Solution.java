package mysource.Solution1;

import java.util.Arrays;

class Solution {
    public int[] twoSum_2021_250(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            map.put(nums[i], i);
        }
        
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if (map.get(target-nums[i]) != null) {
                if (map.get(target-nums[i]) == i)
                    continue;
                int[] temp = new int[2];
                temp[0] = i;
                temp[1] = map.get(target-nums[i]);
                return temp;
            }
        }
        return new int[2];
    }

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