package mysource.Solution75;

class Solution {
    public void sortColors(int[] nums) {
        int i = 0 , j = 0 , k = nums.length-1, temp = 0;
        while ( i <= k ) {
            if ( nums[i] == 0 ) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            if ( nums[i] == 2 ) {
                temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k--;
                i--;
            }
            i++;
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