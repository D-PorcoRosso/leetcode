
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            int sum = 0;
            for ( int j = i ; j < nums.length ; j++ ) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                } 
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] t2 = {-1,-2,-3,-4,100,-5,-6};
        int[] t3 = {-1};
        int[] t4 = {1,2,3,4,5,6,7,8,9};
        int[] t5 = {1,2,3,4,5,6,7,8,8,8,8,8};
        System.out.println(solution.maxSubArray(t1));
        
    }
}