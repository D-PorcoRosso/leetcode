import java.util.*;

class Solution {

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