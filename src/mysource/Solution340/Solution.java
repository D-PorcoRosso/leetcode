package mysource.Solution340;

public class Solution {
    public int lengthOfLongestSubstringKDistinct_2021_amz_TLE(String s, int k) {
        int max = -1;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            Set<Character> container = new HashSet<>();
            int lastIndex = -1;
            for ( int j = i ; j < s.length() ; j++ ) {
                container.add(s.charAt(j));
                if(container.size() > k) {
                    max = Math.max(j-i, max);
                    break;
                } else {
                    max = Math.max(j+1-i, max);
                }
            }
        }
        return max;
    }
}
