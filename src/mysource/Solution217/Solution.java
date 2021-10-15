package mysource.Solution217;

import java.util.HashSet;

class Solution {

    public boolean containsDuplicate_2021_250(int[] nums) {
        HashMap<Integer, Object> mem = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++) {
            if (mem.get(nums[i]) != null) {
                return true;
            }
            mem.put(nums[i], new Object());
        }
        return false;
    }

    public boolean containsDuplicate_2021(int[] nums) {
        HashMap<Integer, Integer> existTable = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            if (existTable.get(nums[i]) == null) {
                existTable.put(nums[i], 1);
            } else
                return true;
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> testDuplicate = new HashSet<Integer>();
        for ( int num : nums ) {
            if (!testDuplicate.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,2,3,4,5};
        System.out.println(solution.containsDuplicate(test));

    }
}