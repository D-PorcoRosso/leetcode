class Solution {
    public int[] bubbleSort(int[] nums) {
        for ( int i = 0 ; i < nums.length ; i++ ) {
            boolean isSwap = false;
            for ( int j = 0 ; j < nums.length-1 ; j++ ) {
                if ( nums[j] > nums[j+1] ) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    isSwap = true;
                }
            }
            if ( !isSwap )
                break;
        }
        return nums;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2,5,7,8,9,3,12,11,4,1,87};
        int[] result1 = solution.bubbleSort(test1);
        for ( int i = 0 ; i < result1.length ; i++ ) {
            System.out.println(result1[i]);
        }
    }
}