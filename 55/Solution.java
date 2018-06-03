import java.util.*;

class Solution {

    public boolean canJump(int[] nums) {
        int localMax = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( i > localMax ) return false;
            localMax = Math.max(localMax, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2,3,1,1,4};
        System.out.println(solution.canJump(test1));
        int[] test2 = {3,2,1,0,4};
        System.out.println(solution.canJump(test2));
    }
}