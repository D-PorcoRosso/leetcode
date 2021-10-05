package mysource.Solution139;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {    
        Boolean[] dpTable = new Boolean[s.length()];
        return isExist(s, wordDict, 0, dpTable);
    }
    
    private boolean isExist (String s, List<String> wordDict, int index, Boolean[] dpTable) {
        if (s.length() == 0)
            return true;
        if (dpTable[index] != null)
            return dpTable[index];
        boolean isExist = false;
        for ( String word : wordDict) {
            if (isMatch(s, word)) {
                isExist |= isExist(s.substring(word.length(), s.length()), wordDict, index+word.length(), dpTable);
                if (isExist) {
                    dpTable[index] = true;
                    return true;
                }
            }
        }
        dpTable[index] = isExist;
        return isExist;
    }
    
    private boolean isMatch(String s, String word) {
        if (word.length() > s.length())
            return false;
        String target = s.substring(0, word.length());
        return target.equals(word);
    }
}
