package mysource.Solution3;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> exists = new HashMap<>();
        int maxCount = 0, currentCount = 0;
        for ( int i = 0 ; i < s.length() ; i++ ) {
            for ( int j = i ; j < s.length() ; j++ ) {
                Character c = s.charAt(j);
                //System.out.println(c);
                if ( exists.get(c) != null ) {
                    exists.clear();
                    currentCount = 0;
                    break;
                } else {
                    exists.put(c,1);
                    currentCount++;
                    if ( maxCount < currentCount )
                        maxCount = currentCount;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("c"));
        System.out.println(solution.lengthOfLongestSubstring("aab"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution.lengthOfLongestSubstring("asjrgapa"));
        System.out.println(solution.lengthOfLongestSubstring("jbpnbwwd"));
    }
}