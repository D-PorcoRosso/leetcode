package mysource.Solution57;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        if (intervals.length == 0) {
            results.add(newInterval);
            return results.toArray(new int[results.size()][]);
        }
     
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for ( int i = 0 ; i < intervals.length ; i++ ) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        int[] newRange = new int[2];
        newRange[0] = -1;
        newRange[1] = -1;
        int startIndex = 0, endIndex = 0;
        
        for (  ; startIndex < start.length; ) {
            if (start[startIndex] < newInterval[0] && end[startIndex] < newInterval[0]) {
                int[] temp = new int[2];
                temp[0] = start[startIndex];
                temp[1] = end[startIndex];
                results.add(temp);
                startIndex++;
                continue;
            }
            if (start[startIndex] > newInterval[0] && end[startIndex] > newInterval[0]) {
                newRange[0] = newInterval[0];
                break;
            }
            if (start[startIndex] <= newInterval[0] && end[startIndex] >= newInterval[0]) {
                newRange[0] = start[startIndex];
                break;
            }
        }
        
        for ( endIndex = startIndex ; endIndex < start.length; ) {
            if (start[endIndex] <= newInterval[1] && end[endIndex] >= newInterval[1]) {
                newRange[1] = end[endIndex];
                int[] temp = new int[2];
                temp[0] = newRange[0];
                temp[1] = newRange[1];
                results.add(temp);
                endIndex++;
                break;
            }
            
            if (start[endIndex] > newInterval[1] && end[endIndex] > newInterval[1]) {
                newRange[1] = newInterval[1];
                int[] temp = new int[2];
                temp[0] = newRange[0];
                temp[1] = newRange[1];
                results.add(temp);
                break;
            }
            
            if (start[endIndex] < newInterval[1] && end[endIndex] < newInterval[1]) {
                endIndex++;
                if (endIndex == start.length) {
                    newRange[1] = newInterval[1];
                    int[] temp = new int[2];
                    temp[0] = newRange[0];
                    temp[1] = newRange[1];
                    results.add(temp);
                    break;
                }
                continue;
            }
        }
        
        for ( ;endIndex < start.length; endIndex++) {
            int[] temp = new int[2];
            temp[0] = start[endIndex];
            temp[1] = end[endIndex];
            results.add(temp);
        }
        
        if (newRange[0] == -1 && newRange[1] == -1) {
            int[] temp = new int[2];
            temp[0] = newInterval[0];
            temp[1] = newInterval[1];
            results.add(temp);
        }
            
        
        return results.toArray(new int[results.size()][]);
    }

    public int[][] insert_2021_250(int[][] intervals, int[] newInterval) {
        
        int[][] resultIntervals = new int[intervals.length+1][2];
        for ( int i = 0 ; i < intervals.length ; i++ ) {
            resultIntervals[i][0] = intervals[i][0];
            resultIntervals[i][1] = intervals[i][1];
        }
        resultIntervals[intervals.length][0] = newInterval[0];
        resultIntervals[intervals.length][1] = newInterval[1];
        Arrays.sort(resultIntervals, new Comparator<int[]>(){
            public int compare(int[]a, int[]b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        int localMin = resultIntervals[0][0];
        int localMax = resultIntervals[0][1];
        List<int[]> temp = new ArrayList<>();
        for (int i = 1 ; i < resultIntervals.length ; i++) {
            if (resultIntervals[i][0] <= localMax){
                localMax = Math.max(resultIntervals[i][1], localMax);
            } else {
                int[] interval = new int[2];
                interval[0] = localMin;
                interval[1] = localMax;
                temp.add(interval);
                localMin = resultIntervals[i][0];
                localMax = resultIntervals[i][1];
            }
        }
        int[] interval = new int[2];
        interval[0] = localMin;
        interval[1] = localMax;
        temp.add(interval);
        int[][] intervalResults = new int[temp.size()][2];
        int i = 0;
        for ( int[] result : temp ) {
            intervalResults[i][0] = result[0];
            intervalResults[i][1] = result[1];
            i++;
        }
        return intervalResults;
    }
}
