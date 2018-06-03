import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        return isExist(0,nums);
    }

    private boolean isExist(int index, int[] nums) {
        int length = nums.length;
        System.out.println(index+":"+nums[index]);
        if ( index == length - 1 )
            return true;
        if ( nums[index] == 0 )
            return false;
        boolean isExist = false;
        for ( int i = 1 ; i <= nums[index] ; i++ ) {
            if ( index+i < length )
                isExist |= isExist(index+i, nums);
        }
        return isExist;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2,3,1,1,4};
        System.out.println(solution.canJump(test1));
        int[] test2 = {3,2,1,0,4};
        System.out.println(solution.canJump(test2));
    }
}