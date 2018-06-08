import java.util.*;
class Solution {
    public void countingSort(int[] nums) {
        int[] range = new int[100];
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        Arrays.fill(range,0);
        for ( int i = 0 ; i < result.length ; i++ ) {
            range[result[i]]++;
        }
        for( int i = 1 ; i < 100 ; i++ ) {
            range[i] += range[i-1];
        }
        for ( int i = 0 ; i < result.length ; i++ ) {
            nums[range[result[i]]-1] = result[i];
            range[result[i]]--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = { 2, 5, 7, 8, 9, 3, 12, 11, 4, 1, 87 };
        solution.countingSort(test1);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i]+",");
        }
        System.out.println();
        int[] test2 = { 1,2,3,4,5 };
        solution.countingSort(test2);
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i]+",");
        }
        System.out.println();
        int[] test3 = { 5,4,3,2,1 };
        solution.countingSort(test3);
        for (int i = 0; i < test3.length; i++) {
            System.out.print(test3[i]+",");
        }
        System.out.println();
        int[] test4 = { 1,1,1,1 };
        solution.countingSort(test4);
        for (int i = 0; i < test4.length; i++) {
            System.out.print(test4[i]+",");
        }
    }
}