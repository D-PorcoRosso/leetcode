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

    public int mySqrt_2021_250(int x) {
        for ( int i = 1 ; i <= x ; i++ ) {
            if ( i*i == x) {
                return i;
            }
            if ( i*i > x) {
                return i-1;
            }
            if ( i*i < 0) {
                return i-1;
            }
        }
        return 0;
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