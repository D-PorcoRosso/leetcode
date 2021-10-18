package mysource.Solution238;

class Solution {

    public int[] productExceptSelf_2021_250(int[] nums) {
        int[] firstRound = new int[nums.length];
        firstRound[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            firstRound[i] = firstRound[i-1]*nums[i];
        }
        int[] secondRound = new int[nums.length];
        secondRound[nums.length-1] = 1;
        for (int i = nums.length-2 ; i >= 0 ; i--) {
            secondRound[i] = secondRound[i+1]*nums[i+1];
        }
        nums[0] = secondRound[0];
        for (int i = 1 ; i < nums.length ; i++ ) {
            nums[i] = firstRound[i-1]*secondRound[i];
        }
        return nums;
    }

    public int[] productExceptSelf_2021(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;

        int[] result = new int[nums.length];
        for ( int i = 1 ; i < nums.length ; i++ ) {
            left[i] = left[i-1] * nums[i-1];
        }
        for ( int i = nums.length - 2 ; i >= 0; i-- ) {
            right[i] = right[i+1]*nums[i+1];
        }
        for (int i = 0 ; i < nums.length ; i++)
            result[i] = left[i]*right[i];
        return result;
    }

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