package mysource.Solution243;

public class Solution {

    public int shortestDistance_2021_250_fast50percent(String[] wordsDict, String word1, String word2) {
        int word1Index = -1, word2Index = -1, min = wordsDict.length;
        for ( int i = 0 ; i < wordsDict.length ; i++ ) {
            if(wordsDict[i].equals(word1)) {
                word1Index = i;
            }
            else if (wordsDict[i].equals(word2))
                word2Index = i;
            if (word1Index != -1 && word2Index != -1) {
                min = Math.min(min, Math.abs(word1Index-word2Index));
            }
        }
        
        return min;
    }

    public int shortestDistance_2021_250_fasteralittle(String[] wordsDict, String word1, String word2) {
        int word1Index = -1, word2Index = -1, min = Integer.MAX_VALUE;
        for ( int i = 0 ; i < wordsDict.length ; i++ ) {
            if(wordsDict[i].equals(word1)) {
                word1Index = i;
            }
            if (wordsDict[i].equals(word2))
                word2Index = i;
            if (word1Index != -1 && word2Index != -1) {
                min = Math.min(min, Math.abs(word1Index-word2Index));
            }
        }
        
        return min;
    }
    public int shortestDistance_2021_250(String[] wordsDict, String word1, String word2) {
        HashMap<String, List<Integer>> mapping = new HashMap<>();
        for ( int i = 0 ; i < wordsDict.length ; i++ ) {
            List<Integer> index = mapping.get(wordsDict[i]);
            if(index == null) {
                index = new ArrayList<>();
                mapping.put(wordsDict[i], index);
            }   
            index.add(i);
        }
        
        List<Integer> w1 = mapping.get(word1);
        List<Integer> w2 = mapping.get(word2);
        
        int min = Integer.MAX_VALUE;
        for (int index1 : w1) {
            for (int index2 : w2) {
                min = Math.min(min, Math.abs(index2 - index1));
            }
        }
        return min;
    }
}
