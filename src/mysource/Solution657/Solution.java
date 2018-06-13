package mysource.Solution657;

public class Solution {
    public boolean judgeCircle(String moves) {
        if ( moves == null || moves.isEmpty() )
            return false;
        char[] chars = moves.toCharArray();
        boolean result = false;
        int x_count = 0, y_count = 0;
        for ( char c : chars ) {
            switch (c) {
                case 'R':
                    x_count = x_count + 1;
                    break;
                case 'L':
                    x_count = x_count - 1;
                    break;
                case 'U':
                    y_count = y_count + 1;
                    break;
                case 'D':
                    y_count = y_count - 1;
                    break;
                default:
                    return false;
            }
        }
        if ( x_count == 0 && y_count == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle(args[0]));
    }
}