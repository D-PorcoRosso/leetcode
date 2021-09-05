package mysource.Solution125;

class Solution {
    public boolean isPalindrome_2021(String s) {
        s = s.toLowerCase();
        List<Character> trimArray = new ArrayList<>();
        for ( int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);
            if ( ('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
                trimArray.add(c);
            }
        }
        Character[] target = new Character[trimArray.size()];
        target = trimArray.toArray(target);
        for ( int i = 0 ; i < target.length/2 ; i++ ) {
            if ( target[i] != target[target.length - 1 - i] )
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        
        char[] array = s.toCharArray();
        int length = array.length;
        for ( int i = 0, j = length - 1 ; i < j ; i++,j-- ) {
            char ci = array[i], cj = array[j];
            while ( !((array[i] <= 'z' && array[i] >= 'a') 
            || (array[i] <= 'Z' && array[i] >= 'A')
            || (array[i] <='9' && array[i]>='0')) && i < j ) {
                i++;
            }
            while ( !((array[j] <= 'z' && array[j] >= 'a') 
            || (array[j] <= 'Z' && array[j] >= 'A')
            || (array[j] <='9' && array[j]>='0')) && i < j ) {
                j--;
            }
            
            if( Character.toLowerCase(array[i]) != 
                Character.toLowerCase(array[j]) )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(".,"));
    }
}