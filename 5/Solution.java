import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        List<String> allString = new ArrayList<>();
        int maxLength = 0;
        String maxString = "";
        for ( int i = 0 ; i < s.length() ; i++ ) {
            String temp = "";
            for ( int j = i ; j < s.length() ; j++ ) {
                temp+=s.charAt(j);
                allString.add(temp);
            }
        }
        for ( String subString : allString ) {
            //System.out.println(subString);
            if ( isPalindromic(subString) ) {
                if ( subString.length() > maxLength ) {
                    maxLength = subString.length();
                    maxString = subString;
                }
            }
            //System.out.println(isPalindromic(subString));
        }
        return maxString;
    }

    private boolean isPalindromic(String s) {
        int length = s.length();
        if ( length == 1 )
            return true;
        int index = 0;
        while (index < length/2) {
            //System.out.println(s.charAt(index));
            //System.out.println(s.charAt(length-index-1));
            //new java.util.Scanner(System.in).nextLine();
            if (s.charAt(index) == s.charAt(length-index-1)) {
                index++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("sss"));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("abdch"));
    }
}