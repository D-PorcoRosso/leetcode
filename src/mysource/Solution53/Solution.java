package mysource.Solution53;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int max = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            max = nums[i] > nums[i] + max ? nums[i] : nums[i] + max;
            maxSum = max > maxSum ? max : maxSum;
        }
        return maxSum;
    }

    public int maxSubArray_2021_o_n(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE, localMax = Integer.MIN_VALUE;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            sum += nums[i];
            if (nums[i] < 0 && sum <= 0) {
                sum = 0;
            } else {
                if (max < sum)
                    max = sum;
            }
            
            if (localMax < nums[i]) {
                localMax = nums[i];
            }
        }
        if (max == Integer.MIN_VALUE)
            max = localMax;
        return max;
    }

    public int maxSubArray_2021(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            int currentSum = 0;
            for ( int j = i ; j < nums.length ; j++ ) {
                currentSum += nums[j];
                if ( currentSum > sum)
                    sum = currentSum;
            }
        }
        return sum;
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