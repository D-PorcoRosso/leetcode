package mysource.Solution76;

public class Solution {
    public String minWindow_2021_250(String s, String t) {
        if (t.length() > s.length())
            return "";
        
        HashMap<Character, Integer> mapping = new HashMap<>();
        HashMap<Character, Integer> original = new HashMap<>();
        for ( int i = 0 ; i < t.length() ; i++ ) {
            mapping.put(t.charAt(i), 0);
            Integer count = original.get(t.charAt(i));
            if (count == null)
                original.put(t.charAt(i), 1);
            else {
                original.put(t.charAt(i), ++count);
            }
        }
        
        
        //find the first mapping full with at least 1
        int end = 0, start = 0, strStart = -1, strEnd = 0;
        //boolean isIncludeLast = false;
        int localMin = Integer.MAX_VALUE;
        for ( ; end <= s.length() ; ) {
            if (isContains(original, mapping)) {
                Integer count = mapping.get(s.charAt(start));
                if (localMin > ((end-1) - start)) {
                    localMin = (end-1) - start;
                    strEnd = end;
                    strStart = start;
                }
                if (count != null) {
                    --count;
                    mapping.put(s.charAt(start), count);
                }
                ++start;
            } else {
                if (end == s.length())
                    break;
                Integer count = mapping.get(s.charAt(end));
                if (count != null) {
                    ++count;
                    mapping.put(s.charAt(end), count);
                    // if (end == s.length() - 1) {
                    //     isIncludeLast = true;
                    // }
                }
                ++end;
            }
        }
        if (strStart == -1)
            return "";
        //end = isIncludeLast ? end : end-1;
        return s.substring(strStart, strEnd);
    }
    
    private boolean isContains(HashMap<Character, Integer> original, HashMap<Character, Integer> mapping) {
        for ( Map.Entry<Character, Integer> entry : mapping.entrySet() ) {
            if (entry.getValue() == 0)
                return false;
            if (original.get(entry.getKey()) > entry.getValue())
                return false;
        }
        return true;
    }

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
