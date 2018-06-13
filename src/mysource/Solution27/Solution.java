package mysource.Solution27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int count = 0;

        if ( nums.length == 0 )
            return 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( nums[i] != val ) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
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
        int[] t4 = {0,1,2,2,3,0,4,2};
        int[] t5 = {1,2,3,4,5,6,7,8,8,8,8,8};
        System.out.println(solution.removeElement(t1, 3));
        print(t1);
        System.out.println(solution.removeElement(t2, 3));
        print(t2);
        System.out.println(solution.removeElement(t3, 3));
        print(t3);
        System.out.println(solution.removeElement(t4, 2));
        print(t4);
        System.out.println(solution.removeElement(t5, 3));
        print(t5);
    }
}