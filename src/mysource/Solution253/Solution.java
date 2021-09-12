package mysource.Solution253;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> minIntervals = new ArrayList<>();
        int maxCount = -1;
        for ( int i = 0 ; i < intervals.length ; i++ ) {
            int min = intervals[i][0], max = intervals[i][1];
            int count = 1, roundIndex = 0;
            for ( int j = 0 ; j < intervals.length ; j++ ) {
                if (i == j)
                    continue;
                if (max <= intervals[j][1] && min >= intervals[j][0]) {
                    ++count;
                }
                if (min < intervals[j][0] && intervals[j][0] < max) {
                    min = intervals[j][0];
                    roundIndex = j;
                    ++count;
                }
                if (max > intervals[j][1] && intervals[j][1] > min) {
                    max = intervals[j][1];
                    if (roundIndex != j)
                        ++count;
                }
            }
            if (count != 0){
                int[] interval = new int[2];
                interval[0] = min;
                interval[1] = max;
                minIntervals.add(interval);
            }
            if (maxCount < count)
                maxCount = count;
        }
        return maxCount;
    }
}
