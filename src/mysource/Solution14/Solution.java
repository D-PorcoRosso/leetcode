package mysource.Solution14;

import java.util.Arrays;

class Solution {

    public String longestCommonPrefix(String[] strs) {
        if ( strs == null || strs.length == 0 )
            return "";
        int min = Integer.MAX_VALUE, index = 0, i = 0;
        for ( String str : strs ) {
            int currentLength = str.length();
            if ( currentLength < min ) {
                min = currentLength;
                index = i;
            }
            i++;
        }
        String ex = strs[index];
        String[] filteredArray = Arrays.stream(strs).filter(e -> !e.equals(ex)).toArray(String[]::new);

        String result = "";
        for ( i = 1 ; i <= min ; i++ ) {
            boolean isAllContains = true;
            String prefix = ex.substring(0,i);
            for ( String str : filteredArray ) {
                if ( !str.startsWith(prefix) ) {
                    isAllContains = false;
                    break;
                }
            }
            if( !isAllContains ) {
                result = ex.substring(0,i-1);
                break;
            } else {
                result = prefix;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs1 = {"geeksforgeeks","geeks","geek","geezer"};
        String[] strs2 = {"geeks","geeks","geeks","geeks"};
        String[] strs3 = {"a","b","c","d"};
        String[] strs4 = {};
        String[] strs5 = {"ca","a"};
        System.out.println(solution.longestCommonPrefix(strs1));
        System.out.println(solution.longestCommonPrefix(strs2));
        System.out.println(solution.longestCommonPrefix(strs3));
        System.out.println(solution.longestCommonPrefix(strs4));
        System.out.println(solution.longestCommonPrefix(strs5));
    }
}