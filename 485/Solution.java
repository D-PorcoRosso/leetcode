import java.util.Currency;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            if ( nums[i] == 0 )
                currentCount = 0;
            else
                currentCount++;

            if ( currentCount > maxCount )
                maxCount = currentCount;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,1,0,1,1,1};
        System.out.println(solution.findMaxConsecutiveOnes(test1));
        int[] test2 = {0,0,0};
        System.out.println(solution.findMaxConsecutiveOnes(test2));
        int[] test3 = {1,1,1,1,1,1};
        System.out.println(solution.findMaxConsecutiveOnes(test3));
    }
}