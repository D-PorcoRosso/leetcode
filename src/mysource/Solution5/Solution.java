package mysource.Solution5;

import java.util.HashMap;

class Solution {
    public String longestPalindrome(String s) {
        HashMap<String, Integer> allString = new HashMap<>();
        int maxLength = 0, length = s.length();
        String maxString = "";
        
        for (int i = 1 ; i < length ; i++) {
            int k = i,j = i+1;
            int localCount = 0;
            while(k>=0 && k<length && j >=0 && j<length) {
                if ( isPass(s,j,k) ) {
                    localCount+=2;
                    if ( localCount > maxLength ) {
                        maxString = s.substring(k,j+1);
                        maxLength = localCount;
                    }
                    j++;
                    k--;
                } else 
                    break;
            }
            k = i-1;
            j = i;
            localCount = 0;
            while(k>=0 && k<length && j >=0 && j<length) {
                if ( isPass(s,j,k) ) {
                    localCount+=2;
                    if ( localCount > maxLength ) {
                        maxString = s.substring(k,j+1);
                        maxLength = localCount;
                    }
                    j++;
                    k--;
                } else 
                    break;
            }
            k = i-1;
            j = i+1;
            localCount = 1;
            while(k>=0 && k<length && j >=0 && j<length) {
                if ( isPass(s,j,k) ) {
                    localCount+=2;
                    if ( localCount > maxLength ) {
                        maxString = s.substring(k,j+1);
                        maxLength = localCount;
                    }
                    j++;
                    k--;
                } else 
                    break;
            }
        }
        if (maxLength == 0)
            maxString += s.charAt(0);
        
        return maxString;
    }

    private boolean isPass(String s, int j, int k) {
        if (s.charAt(j) == s.charAt(k))
            return true;
        return false;
    }

    public int max = 0;
    public String longestPalindrome2021(String s) {
        if (s.length()==0)
            return "";
        if (s.length()==1){
            return s;
        }
        String returnString = "";
        for (int index = 0; index < s.length() ; index++ ) {
            for (int end = s.length()-1; end > index ; end-- ) {
                //System.out.println("starting at index:"+index+" end:"+end);
                if (checkEqual(s, index, end) ) {
                    if (max < end - index + 1) {
                        //System.out.println("index:"+index+" end:"+end);
                        returnString = s.substring(index, end+1);
                        max = end - index + 1;
                    }
                }
            }
        }
        if (max == 0)
            returnString = s.substring(0,1);
        max = 0;
        return returnString;
    }
    private boolean checkEqual(String s, int start, int end) {
        //System.out.println("checkEqual:start:"+start+" end:"+end);
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
            return checkEqual(s, start, end);
        } else {
            return false;
        }
    }

    public String longestPalindrome_2021_pass(String s) {
        if (s.length()==0)
            return "";
        if (s.length()==1){
            return s;
        }
        char[] str = s.toCharArray();
        
        int start = 0, end = 0;
        
        for ( int i = 0 ; i < str.length ; i++ ) {
            int len1 = chechPalindromic(s, i, i);
            int len2 = chechPalindromic(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1)/2;
                end = i+len/2;
            }
        }

        return s.substring(start, end+1);
    }
    
    private int chechPalindromic(String s, int left, int right) {
        char[] str = s.toCharArray();
        int L = left, R = right;
        while( L >= 0 && R < str.length && str[L] == str[R]) {
            L--;
            R++;
        }
        return R-L-1;
    }
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome2021("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        //System.out.println(solution.longestPalindrome2021("babad"));
        // System.out.println(solution.longestPalindrome2021("cbbd"));
        // System.out.println(solution.longestPalindrome2021("abdch"));
        // System.out.println(solution.longestPalindrome2021("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}