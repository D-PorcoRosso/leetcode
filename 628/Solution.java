import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int cond_A = nums[0]*nums[1]*nums[length-1];
        int cond_B = nums[length-3]*nums[length-2]*nums[length-1];
        return cond_A > cond_B ? cond_A : cond_B;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-99,-1,0,1,2,3,40,50};
        int[] test2 = {-99,-1,0,1,2,3};
        int[] test3 = {0,1,2,3,4};
        int[] test4 = {-99,-2,-1,-3,0};

        assert (solution.maximumProduct(test1)==6000);
        System.out.println(solution.maximumProduct(test1));
        assert solution.maximumProduct(test2)==297;
        System.out.println(solution.maximumProduct(test2));
        assert solution.maximumProduct(test3)==24;
        System.out.println(solution.maximumProduct(test3));
        assert solution.maximumProduct(test4)==0;
        System.out.println(solution.maximumProduct(test4));
    }
}