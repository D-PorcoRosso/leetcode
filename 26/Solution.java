import java.util.HashSet;

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        HashSet<Integer> storage = new HashSet<>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( !storage.contains(nums[i]) ) {
                storage.add(nums[i]);
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    private static void print(int[] input) {
        for ( int i : input ) {
            System.out.print(i+",");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,1,1};
        int[] t2 = {};
        int[] t3 = {1};
        int[] t4 = {1,2,3,4,5,6,7,8,9};
        int[] t5 = {1,2,3,4,5,6,7,8,8,8,8,8};
        int[] t6 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution.removeDuplicates(t1));
        print(t1);
        System.out.println(solution.removeDuplicates(t2));
        print(t2);
        System.out.println(solution.removeDuplicates(t3));
        print(t3);
        System.out.println(solution.removeDuplicates(t4));
        print(t4);
        System.out.println(solution.removeDuplicates(t5));
        print(t5);
        System.out.println(solution.removeDuplicates(t6));
        print(t6);
    }
}