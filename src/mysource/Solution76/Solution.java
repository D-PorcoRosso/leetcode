package mysource.Solution76;

public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> counting = new HashMap<>();
        for (int i = 0 ; i < t.length() ; i++) {
            char currentChar = t.charAt(i);
            Integer currentValue = target.get(currentChar);
            if (currentValue != null)
                target.put(currentChar, ++currentValue);
            else
                target.put(currentChar, 1);
            counting.put(currentChar, 0);
        }
        if (t.length() > s.length())
            return "";
        int start = 0, end = 0, min = Integer.MAX_VALUE;
        String minString = "";
        while(end < s.length() || start < s.length()) {
            if (isContains(target, counting)) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    minString = s.substring(start, end);
                }
                char startChar = s.charAt(start);
                Integer currentValue = counting.get(startChar);
                if (currentValue != null) {
                    counting.put(startChar, --currentValue);
                }
                start++;
            } else {
                if (end < s.length()) {
                    char endChar = s.charAt(end);
                    Integer currentValue = counting.get(endChar);
                    if (currentValue != null) {
                        counting.put(endChar, ++currentValue);
                    }
                    end++;
                } else {
                    break;
                }
            }
        }
        return minString;
    }
    private boolean isContains(HashMap<Character, Integer> target, HashMap<Character, Integer> counting) {
        for ( Map.Entry<Character, Integer> value : counting.entrySet() ) {
            char c = value.getKey();
            Integer targetValue = target.get(c);
            if (target.get(c) == null)
                return false;
            Integer countingValue = counting.get(c);
            if (countingValue < targetValue)
                return false;
        }
        return true;
    }
}
