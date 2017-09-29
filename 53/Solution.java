
class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxRange = new int[2];
        int max = Integer.MIN_VALUE;
        int size = nums.length;
        for ( int n = 1 ; n <= size ; n++ ) {
            for ( int j = 0 ; j <= size - n ; j++ ) {
                int temp = 0;
                for ( int k = j ; k < j + n ; k++ ) {
                    temp += nums[k];
                }
                if ( temp > max ) {
                    max = temp;
                    maxRange[0] = j;
                    maxRange[1] = j+n;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,1,1};
        int[] t2 = {-1,-2,-3,-4,100,-5,-6};
        int[] t3 = {-1};
        int[] t4 = {1,2,3,4,5,6,7,8,9};
        int[] t5 = {1,2,3,4,5,6,7,8,8,8,8,8};
        System.out.println(solution.maxSubArray(t1));
        System.out.println(solution.maxSubArray(t2));
        System.out.println(solution.maxSubArray(t3));
        System.out.println(solution.maxSubArray(t4));
        System.out.println(solution.maxSubArray(t5));
    }
}