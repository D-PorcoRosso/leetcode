import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, HashMap<Character, Integer>> allCount = new HashMap<>();
        for ( String s : strs ) {
            HashMap<Character, Integer> count = new HashMap<>();
            char[] cs = s.toCharArray();
            for ( char c : cs ) {                
                if (count.get(c) == null)
                    count.put(c, 1);
                else {
                    int tempCount = count.get(c);
                    count.put(c,++tempCount);
                }
            }
            allCount.put(s, count);
        }
        int length = strs.length;
        boolean[] alreadyDone = new boolean[length];
        List<List<String>> result = new ArrayList<>();
        for ( int i = 0 ; i < length ; i++ ) {
            List<String> anagrams = new ArrayList<>();
            if (!alreadyDone[i]) {
                String current = strs[i];
                anagrams.add(current);
                HashMap<Character, Integer> count = allCount.get(current);
                for ( int j = i + 1 ; j < length ; j++) {
                    HashMap<Character, Integer> compareCount = allCount.get(strs[j]);
                    if ( count.size() != compareCount.size() )
                        continue;
                    int localCount = 0;
                    for ( Map.Entry<Character, Integer> countEntry : count.entrySet() ) {
                        if ( countEntry.getValue() == compareCount.get(countEntry.getKey()) )
                            localCount++;
                        else
                            break;
                    }
                    if ( localCount == count.size() ) {
                        anagrams.add(strs[j]);
                        alreadyDone[j] = true;
                    }
                }
                result.add(anagrams);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(solution.groupAnagrams(test1));
        String[] test2 = {"eat", "tea", "tan", "ate", "nat", "stressed", "desserts"};
        //System.out.println(solution.groupAnagrams(test2));
        String[] test3 = {"boo","bob",""};
        System.out.println(solution.groupAnagrams(test3));
    }
}