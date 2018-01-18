class Solution {
    public int addDigits(int num) {
        int x = num;
        while ( x >= 10 ) {
            int sum = 0;
            String temp = Integer.toString(x);
            for ( int i = 0 ; i < temp.length() ; i++ ) {
                sum += Character.getNumericValue(temp.charAt(i));
            }
            x = sum;
        }
        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(5));
        System.out.println(solution.addDigits(10));
        System.out.println(solution.addDigits(38));
    }
}