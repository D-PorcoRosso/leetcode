package mysource.Solution84;

public class Solution {
    public int largestRectangleArea_2021_250(int[] heights) {
        int max = Integer.MIN_VALUE;
        for ( int i = 0 ; i < heights.length ; i++ ) {
            if (i > 0 && i< heights.length - 2 && heights[i] > heights[i-1] && heights[i] > heights[i+1])
                max = Math.max(max, heights[i]);
            else {
                if ( i > 0 && heights[i] == heights[i-1])
                    continue;
                int start = i, end = i;
                for (  ; start >= 0 ; start-- ) {
                    if (heights[start] < heights[i])
                        break;
                }
                start++;
                for (  ; end < heights.length ; end++ ) {
                    if (heights[end] < heights[i])
                        break;
                }
                int rec = (end-start) * heights[i];
                max = Math.max(max, rec);
            }
            
        }
        return max;
    }
}
