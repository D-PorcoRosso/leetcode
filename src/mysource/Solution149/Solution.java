package mysource.Solution149;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2)
                return points.length;
        Map<Float, Integer> slopeMapping = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for ( int i = 0 ; i < points.length ; i++ ) {
            slopeMapping.clear();
            for ( int j = 0 ; j < points.length ; j++ ) {
                if (i==j)
                    continue;
                if ((points[i][0] - points[j][0]) == 0) {
                    Integer c = slopeMapping.get(Float.MAX_VALUE);
                    if (c == null) {
                        c = 2;
                    } else {
                        ++c;
                    }
                    slopeMapping.put(Float.MAX_VALUE, c);
                    max = Math.max(max, c);
                } else {
                    Float slope = (float)(points[i][1] - points[j][1])/(points[i][0] - points[j][0]);
                    Integer c = slopeMapping.get(slope);
                    if (c == null) {
                        c = 2;
                    } else {
                        ++c;
                    }
                    slopeMapping.put(slope, c);
                    max = Math.max(max, c);
                }
            }
        }
        return max;
    }
}
