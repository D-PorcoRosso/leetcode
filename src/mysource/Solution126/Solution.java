package mysource.Solution126;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {  
        List<List<String>> tempResults = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        boolean[] visited = new boolean[wordList.size()];
        find(beginWord, endWord, visited, 0, tempResults, new ArrayList<>(), wordList);
        
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < tempResults.size() ; i++) {
            if (min > tempResults.get(i).size()) {
                min = tempResults.get(i).size();
            }
        }
        for (int i = 0 ; i < tempResults.size() ; i++) {
            if (min == tempResults.get(i).size()) {
                tempResults.get(i).add(0, beginWord);
                results.add(tempResults.get(i));
            }
        }
        return results;
    }
    
    private void find(String beginWord, String endWord, boolean[] visited, int index, List<List<String>> results, List<String> result, List<String> wordList) {
        
        if (beginWord.equals(endWord)){
            results.add(new ArrayList<>(result));
            return;
        }
        
        for ( int i = 0 ; i < wordList.size() ; i++ ) {
            if (diffByOne(beginWord, wordList.get(i)) && !visited[i]) {
                visited[i] = true;
                result.add(wordList.get(i));
                find(wordList.get(i), endWord, visited, i, results, result, wordList);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }
    
    private boolean diffByOne(String a, String b) {
        int count = 0;
        for (int i = 0 ; i < a.length() ; i++) {
            if ( a.charAt(i) != b.charAt(i) ) {
                if (count < 1)
                    count++;
                else
                    return false;
            }
        }
        return true;
    }
}
