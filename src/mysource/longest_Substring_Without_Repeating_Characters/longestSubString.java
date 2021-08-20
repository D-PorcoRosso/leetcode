package mysource.longest_Substring_Without_Repeating_Characters;


public class longestSubString {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String temp = "";
        for ( int index = 0 ; index < s.length() ; index++ ) {
            temp = temp + s.charAt(index);
            for ( int subIndex = index + 1; subIndex < s.length() ; subIndex++ ) {
                char currentChar = s.charAt(subIndex);
                if (temp.indexOf(currentChar) != -1) {
                    break;
                }
                temp = temp + s.charAt(subIndex);
            }
            if (max < temp.length()) {
                max = temp.length();
            }
            temp = "";
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) throws Exception {
        longestSubString solution = new longestSubString();
        String test1 = "abcabcbb";
        int result1 = 3;
        String test2 = "bbbbb";
        int result2 = 1;
        String test3 = "au";
        int result3 = 2;
        String test4 = "pwwkew";
        int result4 = 3;

        
        if (solution.lengthOfLongestSubstring(test1) != result1) {
            throw new Exception();
        }
        if (solution.lengthOfLongestSubstring(test2) != result2) {
            throw new Exception();
        }
        if (solution.lengthOfLongestSubstring(test3) != result3) {
            throw new Exception();
        }
        if (solution.lengthOfLongestSubstring(test4) != result4) {
            throw new Exception();
        }
    }
}