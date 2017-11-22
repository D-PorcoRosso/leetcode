import java.util.ArrayList;

public class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        ArrayList<String> tests = new ArrayList<>();
        for ( int i = 0 ; i < length ; i++) {
            String root = Character.toString(s.charAt(i));
            tests.add(root);
            for ( int j = i+1 ; j < length ; j++) {
                root += Character.toString(s.charAt(j));
                tests.add(root);
            }
        }
        int count = 0;
        for ( String test : tests ) {
            if (isPalindromic(test))
                count++;
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