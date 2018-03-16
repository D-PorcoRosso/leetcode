class Solution {
    public int addDigits(int num) {
        if ( num == 0 )
            return 0;
        int result = num%9;
        if ( result == 0 )
            return 9;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlterna10ing
        System.out.println(solution.addDigits(9));Bits(7));
        System.out.println(solution.hasAlterna38ngBts(11));

    }
}