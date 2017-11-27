
class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int count = 0;
        if ( length == 0 )
            return 0;
        for ( int i = 0 ; i < length ; i++ ) {
            if ( nums[i] != val ) {
                count++;
            } else {
                nums[i] = -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,1,1};
        int[] t2 = {};
        int[] t3 = {1};
        int[] t4 = {1,2,3,4,5,6,7,8,9};
        int[] t5 = {1,2,3,4,5,6,7,8,8,8,8,8};
        System.out.println(solution.removeElement(t1, 3));
        System.out.println(solution.removeElement(t2, 3));
        System.out.println(solution.removeElement(t3, 3));
        System.out.println(solution.removeElement(t4, 3));
        System.out.println(solution.removeElement(t5, 3));
    }
}