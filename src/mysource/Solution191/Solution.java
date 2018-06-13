import java.util.HashMap;
import java.util.Map;

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while( n > 0 ) {
            if ( (n%2) == 1 ) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.hammingWeight(2147483648));

    }
}