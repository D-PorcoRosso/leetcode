package mysource.Solution249;

public class Solution {
    public List<List<String>> groupStrings_2021_250(String[] strings) {
        HashMap<String, List<String>> mapping = new HashMap<>();
        for ( String s : strings ) {
            checkAndSameGroup(s, mapping);
        }
        List<List<String>> results = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : mapping.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }
    
    private void checkAndSameGroup(String s, HashMap<String, List<String>> mapping) {
        boolean isInAny = false;
        for (Map.Entry<String, List<String>> entry : mapping.entrySet()) {
            if (isSame(s, entry.getKey())) {
                isInAny = true;
                entry.getValue().add(s);
                break;
            }
        }
        if (!isInAny) {
            List<String> result = new ArrayList<>();
            result.add(s);
            mapping.put(s, result);
        }
    }
    
    private boolean isSame(String target, String key) {
        if (target.length() != key.length())
            return false;
        
        int diff = getDiff(target.charAt(0), key.charAt(0));
        for ( int i = 1 ; i < target.length() ; i++ ) {
            if (getDiff(target.charAt(i),key.charAt(i)) != diff)
                return false;
        }
        return true;
    }
    
    private int getDiff(char a, char b) {
        return a-b < 0 ? a - b + 26 : a - b ;
    }
}
