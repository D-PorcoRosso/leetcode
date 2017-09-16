import java.lang.Math.*;
public class Solution {
    public int hammingDistance(int x, int y) {
        if ( x < 0 || y < 0)
            return 0;
        int logx = Solution.log(x,2), logy = Solution.log(y,2);
        System.out.println(logx);
        System.out.println(logy);
        return x > y ? logx - logy : logy - logx;
    }

    static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = Integer.parseInt(args[0]), y = Integer.parseInt(args[1]);
        System.out.println(solution.hammingDistance(x,y));
    }
}