package mysource.Solution152;

public class Solution {
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
