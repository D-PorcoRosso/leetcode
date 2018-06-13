import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int cond_A = nums[0]*nums[1]*nums[length-1];
        int cond_B = nums[length-3]*nums[length-2]*nums[length-1];
        return cond_A > cond_B ? cond_A : cond_B;
    }

    public int maximumProduct2(int[] nums) {
        int[] positives = { -1000, -1000, -1000 };
        int max = -1000;
        int[] negitives = {1000, 1000};
        for (int i = 0 ; i < nums.length ; i++) {
            if (max < nums[i]) {
                max = nums[i];
                positives[0] = max;
            }
        }
        for (int i = 0 ; i < nums.length ; i++) {
            if (positives[1] < nums[i] && nums[i] < positives[0]) {
                positives[1] = nums[i];
            }
        }
        for (int i = 0 ; i < nums.length ; i++) {
            if (positives[2] < nums[i] && nums[i] < positives[0]
                && nums[i] < positives[1]) {
                positives[2] = nums[i];
            }
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (negitives[0] > nums[i]) {
                negitives[0] = nums[i];
            }
        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (negitives[1] > nums[i] && nums[i] > negitives[0]) {
                negitives[1] = nums[i];
            }
        }

        int cond_A = positives[0]*positives[1]*positives[2];
        int cond_B = max*negitives[0]*negitives[1];
        return cond_A > cond_B ? cond_A : cond_B;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {-99,-1,0,1,2,3,40,50};
        int[] test2 = {-99,-1,0,1,2,3};
        int[] test3 = {0,1,2,3,4};
        int[] test4 = {-99,-2,-1,-3,0};

        assert (solution.maximumProduct2(test1)==6000);
        System.out.println(solution.maximumProduct2(test1));
        assert solution.maximumProduct2(test2)==297;
        System.out.println(solution.maximumProduct2(test2));
        assert solution.maximumProduct2(test3)==24;
        System.out.println(solution.maximumProduct2(test3));
        assert solution.maximumProduct2(test4)==0;
        System.out.println(solution.maximumProduct2(test4));
    }
}