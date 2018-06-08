import java.util.*;
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipResult = new ArrayList<>();
        checkString(ipResult, s, "", 0, 1);
        return ipResult;
    }

    private void checkString(List<String> ips, String s, String preStateString, int index, int count) {
        if ( count > 4 )
            return;
        int length = s.length();
        for ( int i = index+1 ; i <= index+3 && i <= length ; i++) {
            int ip = Integer.parseInt(s.substring(index, i));
            if ( 0 <= ip && ip <= 255) {
                String result = preStateString;
                if ( count == 1 )
                    result += ip;
                else
                    result += ("."+ip);
                if ( count == 4 && result.length() == length+3 ) {
                    ips.add(result);
                } else {
                    checkString(ips, s, result, i, count+1);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
    }
}