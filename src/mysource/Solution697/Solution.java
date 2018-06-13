package mysource.Solution697;

import java.util.HashMap;
import java.util.Map;

class Solution {
    class Point {
        public int count;
        public int start;
        public int end;
    }
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Point> counts = new HashMap<>();
        int currentMaxCount = 0, currentMax = 0;
        int count;
        for ( int i = 0 ; i < nums.length ; i++ ) {
            int num = nums[i];
            if (counts.get(num) != null ) {
                Point point = counts.get(num);
                count = point.count;
                count++;
                point.count = count;
                point.end = i;
                counts.put(num, point);
            } else {
                count = 1;
                Point point = new Point();
                point.count = count;
                point.start = i;
                point.end = i;
                counts.put(num, point);
            }
            if ( count > currentMaxCount ) {
                currentMax = num;
                currentMaxCount = count;
            }
        }
        
        int minResult = Integer.MAX_VALUE;
        for ( Map.Entry<Integer, Point> entry : counts.entrySet() ) {
            if ( entry.getValue().count == currentMaxCount ) {
                Point point = entry.getValue();
                int result = point.end - point.start+1;
                if ( result < minResult )
                    minResult = result;
            }
        }
        return minResult;
 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1,2,2,3,1,4,2}; 
        System.out.println(solution.findShortestSubArray(test));
        int[] test1 = {1,2,2,3,1}; 
        System.out.println(solution.findShortestSubArray(test1));
        int[] test2 = {2,1}; 
        System.out.println(solution.findShortestSubArray(test2));
        int[] test3 = {2,1,1,2,1,3,3,3,1,3,1,3,2};
        System.out.println(solution.findShortestSubArray(test3));
    }
}