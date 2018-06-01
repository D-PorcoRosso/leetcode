import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int max = Integer.MIN_VALUE;
        for ( int i = 0 ; i < length ; i++ ) {
            for ( int j = 0 ; j < length ; j++ ) {
                int area = (j-i) * Math.min(height[i],height[j]);
                if ( area > max )
                    max = area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,2,3,4,5};
        System.out.println(solution.maxArea(test1));
        
    }
}