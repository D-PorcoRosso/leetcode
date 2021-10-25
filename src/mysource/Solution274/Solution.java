package mysource.Solution274;

public class Solution {
    public int hIndex_2021_250(int[] citations) {
        int hIndex = 0;
        int max = 0;
        for ( int num : citations ) {
            max = Math.max(num, max);
        }
        for ( int i = 0 ; i <= max ; i++ ) {
            int atLeast = findAtLeast(citations, i);
            if (atLeast >= i && findNoMore(citations, i) <= (citations.length-atLeast))
                hIndex = Math.max(hIndex, i);
        }
        return hIndex;
    }
    
    private int findAtLeast(int[] citations, int target) {
        int count = 0;
        for (int num : citations) {
            if (num >= target)
                count++;
        }
        return count;
    }
    
    private int findNoMore(int[] citations, int target) {
        int count = 0;
        for (int num : citations) {
            if (num < target)
                count++;
        }
        return count;
    }
}
