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

    public boolean validPalindrome_pass(String s) {
        char[] str = s.toCharArray();
        if (isPalindrome(str))
            return true;
        int length = str.length;
        int indexBack = length - 1;
        boolean isExistOneDelete = false;
        for ( int index = 0 ; index <= indexBack ; ) {
            if (str[index] != str[indexBack]) {
                if (!isExistOneDelete) {
                    if (index == indexBack-1)
                        return true;
                    boolean isSubStringPalind = false;
                    if (str[index] == str[indexBack -1]) {
                        char[] subString = new char[indexBack-1-index+1];
                        for ( int i = 0 ; i < subString.length ; i++ ) {
                            subString[i] = str[index+i];
                        }
                        isSubStringPalind = isSubStringPalind || isPalindrome(subString);
                    }
                    if (str[index+1] == str[indexBack]) {
                        char[] subString = new char[indexBack-index-1+1];
                        for ( int i = 0 ; i < subString.length ; i++ ) {
                            subString[i] = str[index+1+i];
                        }
                        isSubStringPalind = isSubStringPalind || isPalindrome(subString);
                    }
                    return isSubStringPalind;
                }
            }
            index++;
            indexBack--;
        }
        return true;
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
