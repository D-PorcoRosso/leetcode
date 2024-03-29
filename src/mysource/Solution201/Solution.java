package mysource.Solution201;

public class Solution {
    public int rangeBitwiseAnd_2021_250(int left, int right) {
        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    public int rangeBitwiseAnd(int left, int right) {
        int andResult = left;
        
        int target = 1;
        if (left < Integer.MAX_VALUE/2) {
            while (target < right && target <= Integer.MAX_VALUE/2+1) {
                if (left <= target && target <= right ) {
                    andResult &= target;
                    if (andResult == 0)
                        return 0;
                }
                target <<= 1;
            }
        }
        
        for ( int i = left ; i < right ; i++) {
            andResult = andResult & i;
            if (andResult == 0)
                return 0;
        }
        andResult = andResult & right;
        return andResult;
    }
}
