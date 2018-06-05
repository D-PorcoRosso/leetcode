class Solution {
    public void sortColors(int[] nums) {
        int rCount = 0, bCount = 0, wCount = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if (nums[i] == 0) rCount++;
            else if ( nums[i] == 1 ) wCount++;
            else bCount++;
        }
        for (int i = 0 ; i < nums.length ; i++ ) {
            if ( rCount > 0 ) {
                nums[i] = 0;
                rCount--;
            } else if ( wCount > 0 ) {
                nums[i] = 1;
                wCount--;
            } else {
                nums[i] = 2;
                bCount--;
            }
        } 
    }

    

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {0,0,1,1,2,2};
        int[] test2 = {2,0,2,1,1,0};
        int[] test3 = {0,1,1,0};
        int[] test4 = {0,0,0,0};
        int[] test5 = {};
        
        solution.sortColors(test1);
        for (int i = 0 ; i < test1.length ; i++ ) System.out.print(test1[i]);
        solution.sortColors(test2);
        for (int i = 0 ; i < test2.length ; i++ ) System.out.print(test2[i]);
    }
}