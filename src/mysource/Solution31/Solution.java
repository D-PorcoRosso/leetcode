package mysource.Solution31;

class Solution {
    public void nextPermutation_2021_250(int[] nums) {
        int minIndex = -1;
        for ( int i = nums.length - 2; i >= 0 ; i-- ) {
            if (nums[i] < nums[i+1]) {
                int localMin = Integer.MAX_VALUE;
                for ( int j = i+1 ; j < nums.length ; j++ ) {
                    if ( nums[j] > nums[i] && localMin >= nums[j] ) {
                        localMin = nums[j];
                        minIndex = j;
                    }
                }
                swap(nums, i, minIndex);
                minIndex = i;
                break;
            }
        }
        reverse(nums, minIndex+1);
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,2,3,4,5};
        solution.nextPermutation(test1);
        for ( int i = 0 ; i < test1.length ; i++ )
            System.out.print(test1[i]+",");
        int[] test2 = {5,4,3,2,1};
        solution.nextPermutation(test2);
        for ( int i = 0 ; i < test2.length ; i++ )
            System.out.print(test2[i]+",");
        int[] test3 = {1,1,5};
        solution.nextPermutation(test3);
        for ( int i = 0 ; i < test3.length ; i++ )
            System.out.print(test3[i]+",");
        int[] test4 = {1,3,2};
        solution.nextPermutation(test4);
        for ( int i = 0 ; i < test4.length ; i++ )
            System.out.print(test4[i]+",");
    }
}