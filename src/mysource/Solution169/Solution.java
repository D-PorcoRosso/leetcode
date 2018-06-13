package mysource.Solution169;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> accumulate = new HashMap<>();
        for ( int i =0; i < nums.length; i++) {
            int count = 0;
            if (accumulate.get(nums[i]) != null) {
                count = accumulate.get(nums[i]);
            }
            count++;
            accumulate.put(nums[i],count);
        }
        int condition = nums.length/2;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : accumulate.entrySet()){
            if ( entry.getValue() > condition) {
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,1,1,2,3};
        int[] test2 = {3,3,4};
        System.out.println(solution.majorityElement(test));
        System.out.println(solution.majorityElement(test2));

    }
}