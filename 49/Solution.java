import java.util.*;

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