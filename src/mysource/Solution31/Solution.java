class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        
        
        for ( int i = 0; i < length/2 ; i++ ) {
            int temp = nums[i];
            nums[i] = nums[length-i-1];
            nums[length-i-1] = temp;
        }
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