package mysource.Solution244;

public class Solution {
    HashMap<String, List<Integer>> mapping = new HashMap<>();
    int distance = Integer.MAX_VALUE;
    
    public WordDistance_2021_250(String[] wordsDict) {
        distance = wordsDict.length;
        for (int i = 0 ; i < distance ; i++ ) {
            List<Integer> index = mapping.get(wordsDict[i]);
            if (index == null) {
                index = new ArrayList<>();
                mapping.put(wordsDict[i], index);
            }
            index.add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        Integer result = null;
        List<Integer> index1 = mapping.get(word1);
        List<Integer> index2 = mapping.get(word2);
        if (index1 == null || index2 == null)
            return result;
        result = distance;
        for ( int i1 : index1 ) {
            for (int i2 : index2 ) {
                result = Math.min(result, Math.abs(i1-i2));
            }
        }
        return result;
    }
}
