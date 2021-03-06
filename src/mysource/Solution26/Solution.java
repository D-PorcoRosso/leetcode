package mysource.Solution26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if ( nums.length == 0 )
            return 0;
        int index = 0;
        int count = 1;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            if ( nums[index] != nums[i] ) {
                index++;
                count++;
                nums[index] = nums[i];
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