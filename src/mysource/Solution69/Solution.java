package mysource.Solution69;

class Solution {
    public int mySqrt(int x) {
        int result = 0;
        for ( int i = 1 ; i <= x ; i++ ) {
            int square = i*i;
            if ( (x - square) < 0 ){
                break;
            }
            result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2));
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(9));
        System.out.println(solution.mySqrt(100));
        System.out.println(solution.mySqrt(1000));
    }
}