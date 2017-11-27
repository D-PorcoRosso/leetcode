
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if ( length == 0 )
            return 0;
        if ( length == 1 )
            return 1;
        int count = 1;
        for ( int i = 0 ; i < length - 1; i++ ) {
            if ( nums[i] != nums[i+1] ) {
                count++;
            }
        }
        if ( nums[length-1] != nums[length-2] )
            count++;
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,1,1};
        int[] t2 = {};
        int[] t3 = {1};
        int[] t4 = {1,2,3,4,5,6,7,8,9};
        int[] t5 = {1,2,3,4,5,6,7,8,8,8,8,8};
        System.out.println(solution.removeDuplicates(t1));
        System.out.println(solution.removeDuplicates(t2));
        System.out.println(solution.removeDuplicates(t3));
        System.out.println(solution.removeDuplicates(t4));
        System.out.println(solution.removeDuplicates(t5));
    }
}