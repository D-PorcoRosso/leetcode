package mysource.Solution287;

class Solution {

    public int findDuplicate_2021_250(int[] nums) {
        if (nums.length <= 1)
            return -1;
        int start = nums[0];
        int end = nums[0];
        do {
            start = nums[start];
            end = nums[nums[end]];
        } while(start != end);
        start = nums[0];
        while(start != end) {
            start = nums[start];
            end = nums[end];
        }
        return end;
    }

    public int findDuplicate(int[] nums) {
        for ( int i = 0 ; i < nums.length ; i++ ) 
            for ( int j = 0 ; j < nums.length ; j++ ) {
                if ( i != j ) {
                    if ( nums[i] == nums[j] )
                        return nums[j];
                }
            }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.generateParenthesis(3));
        int[] test1 = { 1,2,2,3,4,5 };
        int[] test2 = { 1,2,2,2,4,5 };
        int[] test3 = { 1,1 };
        System.out.println(solution.findDuplicate(test1));
        System.out.println(solution.findDuplicate(test2));
        System.out.println(solution.findDuplicate(test3));
    }
}