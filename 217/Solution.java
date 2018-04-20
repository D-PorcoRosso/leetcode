import java.util.Arrays;

class Solution {

    public boolean containsDuplicate(int[] nums) {
        for ( int i = 0 ; i < nums.length ; i++ ) {
            for ( int j = 0 ; j < nums.length ; j++ ) {
                if ( i == j )
                    break;
                else
                    if ( nums[i] == nums[j]) 
                        return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,2,2,4,5};
        System.out.println(solution.containsDuplicate(test));

    }
}