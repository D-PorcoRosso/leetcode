import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0 ; i < length ; i++) {
            if ( count < 2 || nums[i] > nums[count - 2] )
                nums[count++] = nums[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,1,1,1,1,1,2,2,2,2,3,4,4,4,5,5};
        System.out.println(solution.removeDuplicates(test1));
        for ( int i = 0 ; i < test1.length ; i++ ) {
            System.out.print(test1[i]+",");
        }
        System.out.println();
        int[] test2 = {1,1,1};
        System.out.println(solution.removeDuplicates(test2));
        for ( int i = 0 ; i < test2.length ; i++ ) {
            System.out.print(test2[i]+",");
        }
        System.out.println();
        int[] test3 = {1,1,1,1,1,1};
        System.out.println(solution.removeDuplicates(test3));
        for ( int i = 0 ; i < test3.length ; i++ ) {
            System.out.print(test3[i]+",");
        }
        System.out.println();
        int[] test4 = {1,2,2,2};
        System.out.println(solution.removeDuplicates(test4));
        for ( int i = 0 ; i < test4.length ; i++ ) {
            System.out.print(test4[i]+",");
        }
        System.out.println();
    }
}