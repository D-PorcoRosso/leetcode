package mysource.Solution290;

public class Solution {
    public boolean wordPattern_2021_250(String pattern, String s) {
        HashMap<Character, String> mapping = new HashMap<>();
        HashMap<String, Character> reverse = new HashMap<>();
        String[] strs = s.split(" ");
        if (strs.length != pattern.length())
            return false;
        for (int i = 0 ; i < pattern.length() ; i++) {
            if (mapping.containsKey(pattern.charAt(i))) {
                if (!mapping.get(pattern.charAt(i)).equals(strs[i]))
                    return false;
            } else {
                if (reverse.containsKey(strs[i]))
                    return false;
                mapping.put(pattern.charAt(i), strs[i]);
                reverse.put(strs[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
