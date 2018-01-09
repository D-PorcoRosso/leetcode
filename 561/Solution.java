class Solution {

    private int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap)
                break;
        }
        return nums;
    }

    public int arrayPairSum(int[] nums) {
        nums = bubbleSort(nums);
        int sum = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if (i%2 == 0)
                sum+=nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 1, 4, 3, 2 };
        System.out.println(solution.arrayPairSum(test1));
    }
}