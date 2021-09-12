package mysource.Solution252;

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0)
            return true;
        List<int[]> interval = new ArrayList<>();
        interval.add(intervals[0]);
        for ( int i = 1 ; i < intervals.length ; i++ ) {
            for ( int[] range : interval ) {
                if (intervals[i][1] <= range[0]) {
                    
                } else if (intervals[i][0] >= range[1]) {
                    
                } else
                    return false;
            }
            interval.add(intervals[i]);
        }
        return true;
    }
}
