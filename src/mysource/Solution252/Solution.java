package mysource.Solution252;

public class Solution {
    public boolean canAttendMeetings_2021_250(int[][] intervals) {
        if (intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        
        for ( int i = 1 ; i < intervals.length ; i++ ) {
            if (intervals[i][0] < intervals[i-1][1])
                return false;
        }
        return true;
    }

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
