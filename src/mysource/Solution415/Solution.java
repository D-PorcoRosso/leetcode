package mysource.Solution415;

public class Solution {
    public String addStrings_2021_google(String num1, String num2) {
        int index1 = num1.length()-1, index2 = num2.length()-1;
        int count = index1 > index2 ? index2 : index1;
        boolean isCarry = false;
        String result = "";
        while(count >= 0) {
            int n1 = num1.charAt(index1)-'0';
            int n2 = num2.charAt(index2)-'0';
            int sum = n1 + n2;
            if (isCarry)
                sum++;
            isCarry = sum >= 10; 
            result = sum%10 + result;
            count--;
            index1--;
            index2--;
        }
        count = index1 > index2 ? index1 : index2;
        String remain = index1 > index2 ? num1 : num2;
        while(count >= 0) {
            int n = remain.charAt(count)-'0';
            if (isCarry)
                n++;
            isCarry = n >= 10; 
            result = n%10 + result;
            count--;
        }
        if (isCarry) {
            result = 1 + result;
        }
        return result;
    }
}
