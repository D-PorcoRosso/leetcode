package mysource.Solution231;

public class Solution {
    public boolean isPowerOfTwo_2021_250(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        while(n >= 0) {
            if (n == 1)
                return true;
            if (n%2 != 0)
                return false;
            n = n/2;
        }
        return false;
    }
}
