package mysource.Solution680;

public class Solution {
    public boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        if (isPalindrome(str))
            return true;
        for ( int i = 0 ; i < str.length ; i++ ) {
            if(isPalindrome(copyWithoutIndex(str, i)))
                return true;
        }
        return false;
    }
    
    private char[] copyWithoutIndex(char[] array, int index) {
        char[] returnArray = new char[array.length-1];
        for ( int i = 0, copyIndex = 0 ; copyIndex < returnArray.length ; i++, copyIndex++ ) {
            if (i == index) {
                i++;
            }
            returnArray[copyIndex] = array[i];
        }
        return returnArray;
    }
    
    private boolean isPalindrome(char[] array) {
        int length = array.length;
        for ( int i = 0 ; i < length/2 ; i++ ) {
            if (array[i] != array[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
