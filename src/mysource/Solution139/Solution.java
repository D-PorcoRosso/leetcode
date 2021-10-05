package mysource.Solution139;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return isExist(s, wordDict);
    }
    
    private boolean isExist (String s, List<String> wordDict) {
        if (s.length() == 0)
            return true;
        boolean isExist = false;
        for ( String word : wordDict) {
            if (isMatch(s, word)) {
                isExist |= isExist(s.substring(word.length(), s.length()), wordDict);
            }
        }
        return isExist;
    }
    
    private boolean isMatch(String s, String word) {
        if (word.length() > s.length())
            return false;
        String target = s.substring(0, word.length());
        return target.equals(word);
    }
}
