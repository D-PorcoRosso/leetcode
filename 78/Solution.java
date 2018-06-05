import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        if ( nums.length == 0 )
            return result;
        Arrays.sort(nums);
        int index = 0, length = nums.length;
        for( int i = 0 ; i < length ; i++ ) {
            List<Integer> init = new LinkedList<>();
            init.add(nums[i]);
            result.add(init);
        }
        index++;
        for ( ; index < length ; ) {
            List<List<Integer>> resultCopy = new LinkedList<>(result);
            for( List<Integer> temp : resultCopy ) {
                int localMax = Integer.MIN_VALUE;
                for ( Integer t : temp ) if ( t > localMax ) localMax = t; 
                for( int i = 0 ; i < length ; i++ ) {
                    List<Integer> tempCopy = new LinkedList<>(temp);
                    if ( nums[i] > localMax && !tempCopy.contains(nums[i]) ) {
                        tempCopy.add(nums[i]);
                        if ( !result.contains(tempCopy) )
                            result.add(tempCopy);
                    }
                }
            }
            index++;
        }
        result.add(new LinkedList<>());
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1};
        System.out.println(solution.subsets(test));
    }
}