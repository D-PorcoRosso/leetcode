
class Solution {
    public int singleNumner(int[] nums) {
        int single = 0;
        for ( int num : nums ) {
            single = single ^ num;
        }
        return single;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,2,3,2,1};
        int[] t2 = {1,2,2,1,3};
        int[] t3 = {1,2,1,2};
        System.out.println(solution.singleNumner(t1));
        System.out.println(solution.singleNumner(t2));
        System.out.println(solution.singleNumner(t3));
    }
}