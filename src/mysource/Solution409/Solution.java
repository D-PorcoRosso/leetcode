import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);
            if ( counts.get(c) == null ) {
                counts.put(c, 1);
            } else {
                int count = counts.get(c);
                counts.put(c, ++count);
            }
        }

        int lengthCount = 0, maxOdd = 0;

        for ( Map.Entry<Character, Integer> entry : counts.entrySet() ) {
            int value = entry.getValue();
            if ( value % 2 == 0 ) {
                lengthCount += value;
            } else {
                if ( value > maxOdd ) {
                    maxOdd = value;
                }
                lengthCount += ((value/2)*2);
            }
        }

        return maxOdd == 0 ? lengthCount : lengthCount+1 ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("aaaAAbccccdd"));
        System.out.println(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
