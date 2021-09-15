package mysource.Solution647;

import java.util.ArrayList;

public class Solution {
    public int countSubstrings_2021(String s) {
        char[] str = s.toCharArray();
        int start = 0, end = 0, index = 1, count = 0;
        while (index <= str.length) {
            for ( int i = 0 ; i+index <= str.length; i++ ) {
                String subS = s.substring(i,i+index);
                char[] subStr = subS.toCharArray();
                if (isPalindromicString(subStr))
                    ++count;
            }
            index++;
        }
        return count;
    }
    
    private boolean isPalindromicString (char[] array) {
        int length = array.length;
        for ( int i = 0 ; i < length/2 ; i++ ) {
            if (array[i] != array[length-1-i])
                return false;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int length = s.length();
        ArrayList<String> tests = new ArrayList<>();
        int count = 0;
        for ( int i = 0 ; i < length ; i++) {
            String root = Character.toString(s.charAt(i));
            count++;
            for ( int j = i+1 ; j < length ; j++) {
                root += Character.toString(s.charAt(j));
                if (isPalindromic(root))
                    count++;
            }
        }
        return count;
    }

    private boolean isPalindromic(String test) {
        int length = test.length();
        if (length == 1)
            return true;
        for( int i = 0 ; i < length ; i++) {
            if ( test.charAt(i) != test.charAt(length - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("aaa"));
        System.out.println(solution.countSubstrings("abcba"));
        System.out.println(solution.countSubstrings("bacd"));
    }
}