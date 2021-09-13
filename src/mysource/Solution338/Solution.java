package mysource.Solution338;

import java.util.ArrayList;

class Solution {
    public int[] countBits_2021(int n) {
        int[] returnBits = new int[n+1];
        returnBits[0] = 0;
        if (n == 0)
            return returnBits;
        returnBits[1] = 1;
        int pow = 1;
        for ( int i = 2 ; i <= n ; i++ ) {
            int base = 1 << pow;
            if (i/base > 1) {
                ++pow;
                base = 1 << pow;
            }
            returnBits[i] = returnBits[i % (int)base] + 1;
        }
        return returnBits;
    }

    public int[] countBits(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        int index = 0;
        for ( int i = 1 ; i <= num ; i++) {
            double log2 = Math.log(i) / Math.log(2);
            if ((log2 == Math.floor(log2)) && !Double.isInfinite(log2)) {
                index = 0;
            } else {
                index++;
            }
            result.add(result.get(index)+1);
        }
        int[] ret = new int[result.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = result.get(i).intValue();
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBits(10));
    }
}