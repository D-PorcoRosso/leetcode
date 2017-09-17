import java.lang.Math.*;
public class Solution {
    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        int normalCount = String.valueOf(x).length();
        if ( x < 0 )
            isPalindrome = false;
        while ( x > 1 ) {
            int length = String.valueOf(x).length();
            
            if ( length != normalCount ) {
                System.out.println(x % (int)Math.pow(10,length-1));
                if ( x % (int)Math.pow(10,normalCount - length) != 0) {
                    isPalindrome = false;
                    break;
                }
                x = x / (int)Math.pow(10,normalCount - length);
                length = normalCount = String.valueOf(x).length();
            }
            
            if ( x/(int)Math.pow(10,length-1) != x%10 ) {
                isPalindrome = false;
                break;
            } else {
                x = x - (x/(int)Math.pow(10,length-1))*(int)Math.pow(10,length-1);
                x = x / 10;
            }
            normalCount = normalCount - 2;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = Integer.parseInt(args[0]);
        System.out.println(solution.isPalindrome(x));
    }
}