package mysource.Solution245;

public class Solution {
    public int shortestWordDistance_2021_250(String[] wordsDict, String word1, String word2) {
        int word1Index = -1, word2Index = -1, min = wordsDict.length;
        for ( int i = 0 ; i < wordsDict.length ; i++ ) {
            if( wordsDict[i].equals(word1) ) {
                word1Index = i;
            }
            if( wordsDict[i].equals(word2) ) {
                if (word1.equals(word2)) 
                    word1Index = word2Index;
                word2Index = i;
            }
            if (word1Index != -1 && word2Index != -1) {
                min = Math.min(min, Math.abs(word1Index-word2Index));
            }
        }
        
        return min;
    }
}
