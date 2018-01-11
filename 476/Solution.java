class Solution {
    public int findComplement(int num) {
        if ( 0 < num && num < Integer.MAX_VALUE ) {
            int digital = (int)(Math.log(num)/Math.log(2))+1;
            if ( digital == 31 ) {
                int max = (int)Math.pow(2,digital);
                return num^max;
            } else {
                int max = (int)Math.pow(2,digital)-1;
                return num^max;
            }
        } else {
            if ( num == Integer.MAX_VALUE ) {
                return 0;
            } else
                return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));
        System.out.println(solution.findComplement(65535));
        System.out.println(solution.findComplement(Integer.MAX_VALUE-1));
    }
}