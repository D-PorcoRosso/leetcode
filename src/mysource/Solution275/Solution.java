package mysource.Solution275;

public class Solution {
    public int hIndex_2021_250(int[] citations) {
        int hIndex = 0;
        while(hIndex < citations.length && citations[citations.length-1-hIndex] > hIndex) {
            hIndex++;
        }
        return hIndex;
    }
}
