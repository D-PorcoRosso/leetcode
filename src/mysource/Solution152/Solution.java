package mysource.Solution152;

public class Solution {

    public int maxProduct_2021_250(int[] nums) {
        if ( nums.length == 0)
            return 0;
        
        int max = nums[0], min = nums[0], returnMax = max;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            int localMin = min, localMax = max;
            max = Math.max(nums[i], Math.max(localMax*nums[i], localMin*nums[i]));
            min = Math.min(nums[i], Math.min(localMax*nums[i], localMin*nums[i]));
            returnMax = Math.max(returnMax, max);
        }
        
        return returnMax;
    }

    public int maxProduct_2021_o_n(int[] nums) {
        if (nums.length == 0)
            return 0;
        int localMax = nums[0], localMin = nums[0], max = localMax;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            int temp = Math.max(nums[i], Math.max(nums[i]*localMax, nums[i]*localMin));
            localMin = Math.min(nums[i], Math.min(nums[i]*localMax, nums[i]*localMin));
            localMax = temp;
            if (localMax > max)
                max = localMax;
        }
        return max;
    }

    public int maxProduct_2021(int[] nums) {
        int product = 1, maxProduct = Integer.MIN_VALUE;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            product = 1;
            for ( int j = i ; j < nums.length ; j++ ) {
                product *= nums[j];
                if (product > maxProduct)
                    maxProduct = product;
            }
        }
        return maxProduct;
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for ( int productCount = 1 ; productCount <= nums.length ; productCount++ ) {
            for ( int index = 0 ; index < nums.length ; index++ ) {
                int i = 0;
                int product = 1;
                while(i < productCount && index+i < nums.length) {
                    product = product * nums[index+i];
                    i++;
                }
                if (product > max)
                    max = product;
            }
        }
        return max;
    }
}
