import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        for ( int i = 0 ; i < numbers.length ; i++ ) {
            for ( int j = i+1 ; j < numbers.length ; j++ ) {
                if ( (numbers[i]+numbers[j]) == target ) {
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {2,7,11,15};
        int[] results = solution.twoSum(test, 9);
        for ( int result : results ) {
            System.out.println(result);
        }
        int[] test1 = {0,0,3,4};
        results = solution.twoSum(test1, 0);
        for ( int result : results ) {
            System.out.println(result);
        }

    }
}