
class Solution {
    public int searchInsert(int[] nums, int target) {
        for ( int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == target || target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,3,5,6};
        int[] t2 = {1};
        int[] t3 = {1,3};
        System.out.println(solution.searchInsert(t2, 0));
        assert (solution.searchInsert(t1, 3) == 1 ) : "error";
        System.out.println("1 true");
        assert (solution.searchInsert(t1, 8) == 4 ) : "error";
        System.out.println("2 true");
        assert (solution.searchInsert(t1, 1) == 0 ) : "error";
        System.out.println("3 true");
        assert (solution.searchInsert(t1, 6) == 3 ) : "error";
        System.out.println("4 true");
        assert (solution.searchInsert(t2, 0) == 0 ) : "error";
        System.out.println("5 true");
        assert (solution.searchInsert(t3, 2) == 1 ) : "error";
        System.out.println("6 true");
    }
}