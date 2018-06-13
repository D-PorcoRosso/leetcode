class Solution {
    public boolean hasAlternatingBits(int n) {
        int preMod = 0, count = 0;
        do {
            int currentMod = n%2;
            if ( count!=0 && (preMod^currentMod) != 1 )
                return false;
            preMod = currentMod;
            n = n / 2;
            count++;
        } while ( n != 0 );
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
        System.out.println(solution.hasAlternatingBits(10));
    }
}