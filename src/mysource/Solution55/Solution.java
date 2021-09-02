package mysource.Solution55;

class Solution {

    public boolean canJump(int[] nums) {
        int localMax = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( i > localMax ) return false;
            localMax = Math.max(localMax, i+nums[i]);
        }
        return true;
    }

    public boolean canJump_2021(int[] nums) {
        int currentMax = nums[0];
        if (currentMax == 0 && nums.length > 1)
            return false;
        for ( int i = 1 ; i < nums.length -1 ; i++) {
            if (currentMax-1 < nums[i]) {
                currentMax = nums[i];
            } else {
                currentMax--;
            }
            if (currentMax == 0)
                return false;
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