import java.util.*;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("sss"));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("abdch"));
        System.out.println(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}