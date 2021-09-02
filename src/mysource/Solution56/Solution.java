package mysource.Solution56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public String toString() {
            return "start:"+start+" end:"+end;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if ( intervals.size() == 0 )
            return new ArrayList<Interval>();
        if ( intervals.size() == 1 ) {
            return intervals;
        }

        Collections.sort( intervals, new Comparator<Interval>(){
            public int compare( Interval o1, Interval o2 ) {
                if ( o1.start < o2.start )
                    return -1;
                else if (o1.start > o2.start)
                    return 1;
                return 0;
            }
        });
        
        List<Interval> result = new ArrayList<>();
        
        int localMax = intervals.get(0).end;
        int localMin = intervals.get(0).start;
        
        for ( Interval interval : intervals ) {
            if (interval.start <= localMax) {
                localMax = Math.max(interval.end, localMax);
            } else {
                result.add(new Interval(localMin, localMax));
                localMin = interval.start;
                localMax = interval.end;
            }
        }
        result.add(new Interval(localMin, localMax));

        return result;
    }

    public int[][] merge_2021(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int local_min = intervals[0][0], local_max = intervals[0][1];
        for (int i = 1 ; i < intervals.length ; i++) {
            if (intervals[i][0] >= local_min && intervals[i][0] <= local_max) {
                local_max = local_max >= intervals[i][1] ? local_max : intervals[i][1];
            } else {
                int[] result = new int[2];
                result[0] = local_min;
                result[1] = local_max;
                results.add(result);
                local_min = intervals[i][0];
                local_max = intervals[i][1];
            }
        }
        int[] result = new int[2];
        result[0] = local_min;
        result[1] = local_max;
        results.add(result);
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Interval> test1 = new ArrayList<>();
        test1.add(new Interval(1,3));
        test1.add(new Interval(2,6));
        test1.add(new Interval(8,10));
        test1.add(new Interval(15,18));
        System.out.println(solution.merge(test1));
        List<Interval> test2 = new ArrayList<>();
        test2.add(new Interval(1,4));
        test2.add(new Interval(4,5));
        System.out.println(solution.merge(test2));
        List<Interval> test3 = new ArrayList<>();
        test3.add(new Interval(1,6));
        test3.add(new Interval(2,3));
        System.out.println(solution.merge(test3));
        List<Interval> test4 = new ArrayList<>();
        test4.add(new Interval(1,6));
        test4.add(new Interval(2,8));
        test4.add(new Interval(3,4));
        System.out.println(solution.merge(test4));
        List<Interval> test5 = new ArrayList<>();
        test5.add(new Interval(1,6));
        System.out.println(solution.merge(test5));
        List<Interval> test6 = new ArrayList<>();
        System.out.println(solution.merge(test6));
        List<Interval> test7 = new ArrayList<>();
        test7.add(new Interval(1,4));
        test7.add(new Interval(0,4));
        System.out.println(solution.merge(test7));
        List<Interval> test8 = new ArrayList<>();
        test8.add(new Interval(1,4));
        test8.add(new Interval(0,0));
        System.out.println(solution.merge(test8));
        List<Interval> test9 = new ArrayList<>();
        test9.add(new Interval(2,3));
        test9.add(new Interval(4,5));
        test9.add(new Interval(6,7));
        test9.add(new Interval(8,9));
        test9.add(new Interval(1,10));
        System.out.println(solution.merge(test9));
    }
}