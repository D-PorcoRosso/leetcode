package mysource.Solution336;

public class Solution {
    public List<List<Integer>> palindromePairs_2021_250_TLE(String[] words) {
        List<List<Integer>> results = new ArrayList<>();

        for ( int i = 0 ; i < words.length ; i++ ) {
            for ( int j = 0 ; j < words.length ; j++ ) {
                if ( i == j )
                    continue;
                if(isPalindrome(words[i]+words[j])) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    results.add(result);
                }
            }
        }
        return results;
    }
    
    private boolean isPalindrome(String s) {
        for ( int i = 0 ; i < s.length()/2 ; i++ ) {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
