package mysource.Solution278;

public class Solution {
    public int firstBadVersion_2021_250(int n) {
        int start = 1, end = n, mid=-1;
        while(end >= start) {
            mid = (end-start)/2+start;
            if (isBadVersion(mid)) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
