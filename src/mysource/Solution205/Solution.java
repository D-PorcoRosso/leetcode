package mysource.Solution205;

public class Solution {
    public boolean isIsomorphic_2021_250(String s, String t) {
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(s.charAt(0), t.charAt(0));
        for (int i = 1 ; i < s.length() ; i++) {
            if (mapping.get(s.charAt(i)) != null) {
                if (mapping.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                for ( Map.Entry<Character, Character> entry : mapping.entrySet()) {
                    if(entry.getValue() == t.charAt(i))
                        return false;
                }
                mapping.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
