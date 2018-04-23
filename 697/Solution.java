import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int currentMaxCount = 0, currentMax = 0;
        int count;
        for ( int num : nums ) {
            if (counts.get(num) != null ) {
                count = counts.get(num);
                counts.put(num, ++count);
            } else {
                count = 1;
                counts.put(num, count);
            }
            if ( count > currentMaxCount ) {
                currentMax = num;
                currentMaxCount = count;
            }
        }
        
        int minResult = Integer.MAX_VALUE;
        for ( Map.Entry<Integer, Integer> entry : counts.entrySet() ) {
            System.out.println(entry.getValue());
            if ( entry.getValue() == currentMaxCount ) {
                int result = 0, thisCount = currentMaxCount;
                boolean startCount = false;
                for ( int num : nums ) {
                    if ( num == entry.getKey() ) {
                        thisCount--;
                        startCount = true;
                    }
                    if ( startCount )
                        result++;
                    if ( thisCount == 0 )
                        break;
                }
                if ( result < minResult )
                    minResult = result;
            }
        }
        return minResult;
 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,2,2,3,1,4,2}; 
        //System.out.println(solution.findShortestSubArray(test));
        int[] test1 = {1,2,2,3,1}; 
        //System.out.println(solution.findShortestSubArray(test1));
        int[] test2 = {1}; 
        //System.out.println(solution.findShortestSubArray(test2));
        int[] test3 = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        System.out.println(solution.findShortestSubArray(test3));
    }
}