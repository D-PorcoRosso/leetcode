package mysource.Solution140;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> results = new ArrayList<>();
        Boolean[] dpTable = new Boolean[s.length()];        
        isExist(s, wordDict, 0, dpTable, results, new ArrayList<>());
        List<String> returnResult = new ArrayList<>();
        for ( List<String> temp : results ) {
            String w = "";
            for (String t : temp) {
                if (w.equals(""))
                    w = t;
                else
                    w += (" "+t);
            }
            returnResult.add(w);
        }
        return returnResult;
    }
    
    private boolean isExist (String s, List<String> wordDict, int index, Boolean[] dpTable, List<List<String>> results, List<String> result) {
        if (s.length() == 0) {
            results.add(new ArrayList<>(result));
            return true;
        }

        // if (dpTable[index] != null)
        //     return dpTable[index];
        boolean isExist = false;
        for ( String word : wordDict) {
            if (isMatch(s, word)) {
                result.add(word);
                isExist |= isExist(s.substring(word.length(), s.length()), wordDict, index+word.length(), dpTable, results, result);
                result.remove(result.size()-1);
                // if (isExist) {
                //     dpTable[index] = true;
                //     return true;
                // }
            }
        }
        dpTable[index] = isExist;
        return isExist;
    }
}
