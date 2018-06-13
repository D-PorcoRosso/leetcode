package mysource.Solution540;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        for ( int i = 0 ; i < nums.length - 2 ; i+=2 ) {
            if ( nums[i] != nums[i+1] ) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,1,2,3,3,4,4,8,8};
        System.out.println(solution.singleNonDuplicate(test1));
        int[] test2 = {1,1,2};
        System.out.println(solution.singleNonDuplicate(test2));
    }
}