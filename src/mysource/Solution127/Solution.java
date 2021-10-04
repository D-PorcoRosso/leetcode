package mysource.Solution127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {  
        if (!wordList.contains(endWord))
            return 0;
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
        if (min == Integer.MAX_VALUE)
            return 0;
        
        return min+1;
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> test1 = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        
        System.out.println(solution.ladderLength("qa","sq",test1));
    }
}