package mysource.Solution1859;

public class Solution {
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        StringBuilder builder = new StringBuilder();
        HashMap<Integer, String> mapping = new HashMap<>();
        for (int i = 0 ; i < strs.length ; i++) {
            int index = strs[i].charAt(strs[i].length()-1) - '0';
            mapping.put(index, strs[i].substring(0,strs[i].length()-1));
        }
        
        for ( int i = 1 ; i <= strs.length ; i++ ) {
            builder.append(mapping.get(i));
            if (i != strs.length)
                builder.append(" ");
        }
        return builder.toString();
    }
}
