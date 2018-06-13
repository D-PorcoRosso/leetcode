package mysource.Solution238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean isZero = false;
        int zeroCount = 0;
        for ( int i = 0 ; i < nums.length ; i++){
            if ( nums[i] == 0)
                zeroCount++;
            else
                product *= nums[i];
        }
        for ( int i = 0 ; i < nums.length ; i++){
            if ( zeroCount > 0 ) {
                if ( nums[i] == 0 ){
                    if ( zeroCount == 1)
                        nums[i] = product;
                    else
                        nums[i] = 0;
                } else {
                    nums[i] = 0;
                }
            } else
                nums[i] = product / nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = { 1, 2, 3, 4 };
        test = solution.productExceptSelf(test);
        for ( int i = 0 ; i < test.length ; i++){
            System.out.println(test[i]+",");
        }

        int[] test2 = { 0, 0 };
        test2 = solution.productExceptSelf(test2);
        for ( int i = 0 ; i < test2.length ; i++){
            System.out.println(test2[i]+",");
        }

    }
}