package mysource.Solution340;

public class Solution {
    public int lengthOfLongestSubstringKDistinct_2021_amz(String s, int k) {
        int max = -1;
        int i = 0, j = 0;
        HashMap<Character, Integer> container = new HashMap<>();
        while (j < s.length()) {
            if (container.size() <= k) {
                Character end = s.charAt(j);
                if (container.containsKey(end)) {
                    int count = container.get(end);
                    count++;
                    container.put(end, count);
                } else {
                    container.put(end, 1);
                }
                max = Math.max(max, j-i);
                j++;
            } else {
                Character start = s.charAt(i);
                if (container.containsKey(start)) {
                    int count = container.get(start);
                    if (count == 1)
                        container.remove(start);
                    else {
                        count--;
                        container.put(start, count);
                    }
                }
                i++;
            }   
        }
        if (i == 0 && container.size() <= k)
            max++;
        else if (j == s.length() && container.size() <= k)
            max = Math.max(max, j-i);
        return max;
    }
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
