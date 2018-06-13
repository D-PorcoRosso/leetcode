package mysource.Solution520;

class Solution {
    public boolean detectCapitalUse(String word) {
        int wordLength = word.length();
        
        if ( wordLength == 0 ) 
            return false;
        if ( wordLength == 1 )
            return true;

        if ( Character.isUpperCase(word.charAt(0)) ) {
            if ( Character.isUpperCase(word.charAt(1)) ) {
                for ( int i = 2 ; i < word.length() ; i++ ) {
                    if ( !Character.isUpperCase(word.charAt(i)) )
                        return false;
                }
            } else {
                for ( int i = 2 ; i < word.length() ; i++ ) {
                    if ( Character.isUpperCase(word.charAt(i)) )
                        return false;
                }
            }
        } else {
            for ( int i = 1 ; i < word.length() ; i++ ) {
                if ( Character.isUpperCase(word.charAt(i)) )
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("leetcode"));
        System.out.println(solution.detectCapitalUse("Google"));
        System.out.println(solution.detectCapitalUse("GooGle"));
        System.out.println(solution.detectCapitalUse("GoOGLE"));
        System.out.println(solution.detectCapitalUse("G"));
        System.out.println(solution.detectCapitalUse("Go"));
        System.out.println(solution.detectCapitalUse("GO"));
        System.out.println(solution.detectCapitalUse("oG"));
        System.out.println(solution.detectCapitalUse("o"));
        System.out.println(solution.detectCapitalUse("oo"));
    }
}