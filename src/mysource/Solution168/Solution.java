package mysource.Solution168;

public class Solution {
    public String convertToTitle(int columnNumber) {
        int index = 0, temp = columnNumber;
        String result = "";
        while (temp > 0) {
            int mod = (temp-1) % 26;
            temp = (temp-1)/26;
            result = mapping(mod) + result;
        }
        return result;
    }
    
    private String mapping(int num) {
        int init = 'A'+ num;
        return Character.toString(init);
    }
}
