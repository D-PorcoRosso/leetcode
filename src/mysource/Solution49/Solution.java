package mysource.Solution49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String , ArrayList<String>> accumulate = new HashMap<>();
        for ( String s : strs ) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (!accumulate.containsKey(key))
                accumulate.put(key, new ArrayList<String>());
            accumulate.get(key).add(s);
        }
        for ( List<String> s : accumulate.values() )
            result.add(s);
        return result;
    }

    public List<List<String>> groupAnagrams_2021(String[] strs) {
        List<HashMap<Character, Integer>> compare = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> hashResults = new HashMap<>();
        for ( int i = 0 ; i < strs.length ; i++ ) {
            String str = strs[i];
            HashMap<Character, Integer> anagram = new HashMap<>();
            for ( int j = 0 ; j < str.length() ; j++ ) {
                char currentCh = str.charAt(j);
                if (anagram.get(currentCh) == null) {
                    anagram.put(currentCh, 1);
                } else {
                    anagram.put(currentCh, anagram.get(currentCh)+1);
                }
            }
            if (compare.contains(anagram)){
                hashResults.get(anagram).add(str);
            } else {
                compare.add(anagram);
                List<String> tempStr = new ArrayList<>();
                tempStr.add(str);
                results.add(tempStr);
                hashResults.put(anagram, tempStr);
            }
        }
        return results;        
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(solution.groupAnagrams(test1));
        String[] test2 = {"eat", "tea", "tan", "ate", "nat", "stressed", "desserts"};
        //System.out.println(solution.groupAnagrams(test2));
        String[] test3 = {"fat","asp",""};
        System.out.println(solution.groupAnagrams(test3));
    }
}