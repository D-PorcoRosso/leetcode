package mysource.Solution696;

public class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0, length = s.length(), createSubStrings = 2;
        List<String> subStrings = new ArrayList<>();
        String str1 = "10", str2 = "01";
        subStrings.add(str1);
        subStrings.add(str2);
        while (createSubStrings <= length) {
            str1 = "1"+str1+"0";
            str2 = "0"+str2+"1";
            subStrings.add(str1);
            subStrings.add(str2);
            createSubStrings+=2;
        }
        for ( String str : subStrings ) {
            int index = s.indexOf(str);
            while (index >= 0) {
                count++;
                index = s.indexOf(str, index+1);
            }
        }
        return count;
    }
}
