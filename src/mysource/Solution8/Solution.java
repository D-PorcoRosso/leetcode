package mysource.Solution8;

public class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0)
            return 0;
        char[] str = s.toCharArray();
        if (!isValid(str[0]))
            return 0;
        List<Integer> numbers = new ArrayList<>();
        boolean isNag = false, isPos = false;
        for ( int i = 0 ; i < str.length ; i++ ) {
            if (isValid(str[i])) {
                if (str[i] == ' ') {
                    if (numbers.size() != 0)
                        return genNumber(numbers, isNag, isPos);
                    if (isNag || isPos)
                        return 0;
                    continue;
                }
                if (str[i] == '-') {
                    if (numbers.size() != 0)
                        return genNumber(numbers, isNag, isPos);
                    if (!isNag && !isPos)
                        isNag = true;
                    else
                        return 0;
                    continue;
                }
                if (str[i] == '+') {
                    if (numbers.size() != 0)
                        return genNumber(numbers, isNag, isPos);
                    if (!isNag && !isPos)
                        isPos = true;
                    else
                        return 0;
                    continue;
                }
                if (isNag)
                    numbers.add(0-Character.getNumericValue(str[i]));
                else
                    numbers.add(Character.getNumericValue(str[i]));
            } else break;
        }
        return genNumber(numbers, isNag, isPos);
    }
    
    private int genNumber(List<Integer> nums, boolean isNag, boolean isPos) {
        int index = nums.size();
        int sum = 0;
        boolean isExceed = false;
        for (int num : nums) {
            sum += num * Math.pow(10, index-1);
            if ((sum >= Integer.MAX_VALUE || sum <= Integer.MIN_VALUE) && index >= 1 && num > 8) 
                isExceed = true;
            index--;
        }
        if (sum >= Integer.MAX_VALUE && isExceed){
            if (isNag)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        if (sum <= Integer.MIN_VALUE && isExceed) {
            if (isPos)
                return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
        return sum;
    }
    
    private boolean isValid(char c) {
        if ( c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
           || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
           || c == ' ' || c == '+' || c == '-')
            return true;
        return false;
    }
}
