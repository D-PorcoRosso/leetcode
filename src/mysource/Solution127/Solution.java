import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if ( !wordList.contains(endWord) )
            return 0;

        int count = 1;
        List<String> cpWordList;
        List<String> tempEndWords = new LinkedList<>();
        tempEndWords.add(endWord);
        wordList.remove(endWord);
        while(!wordList.isEmpty()) {
            cpWordList = new LinkedList<>(wordList);
            List<String> cpEndWords = new LinkedList<>(tempEndWords);
            tempEndWords.clear();
            System.out.println(cpWordList);
            boolean hasWord = false;
            for ( String word : cpWordList ) {
                int wordDiffCount = 0;
                for ( String temp : cpEndWords ) {
                    for ( int i = 0 ; i < word.length() ; i++ ) {
                        if ( word.charAt(i) != temp.charAt(i) )
                            wordDiffCount++;
                    }
                    if ( wordDiffCount == 1 ) {
                        if ( !tempEndWords.contains(word) )
                            tempEndWords.add(word);
                        wordList.remove(word);
                        hasWord = true;
                    }
                    wordDiffCount = 0;
                }
            }
            if ( hasWord )
                count++;
            System.out.println(tempEndWords);
            System.out.println(wordList);
        }
        int wordDiffCount = 0;
        for ( String temp : tempEndWords ) {
            for ( int i = 0 ; i < temp.length() ; i++ ) {
                if ( beginWord.charAt(i) != temp.charAt(i) )
                    wordDiffCount++;
            }
            if ( wordDiffCount == 1 ) {
                return count+1;
            }
            wordDiffCount = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> test1 = new ArrayList<>();
        test1.add("hot");
        test1.add("dot");
        test1.add("dog");
        test1.add("lot");
        test1.add("log");
        test1.add("cog");
        System.out.println(solution.ladderLength("hit","cog",test1));
    }
}