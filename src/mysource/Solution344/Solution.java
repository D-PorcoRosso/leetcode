package mysource.Solution344;

class Solution {
    public String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for ( int i = s.length() - 1 ; i >= 0 ; i-- ) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseString("hello"));
    }
}