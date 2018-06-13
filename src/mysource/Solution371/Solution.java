package mysource.Solution371;

class Solution {
    public int getSum(int a, int b) {
        String tempa = Integer.toBinaryString(a);
        String tempb = Integer.toBinaryString(b);
        tempa = new StringBuilder(tempa).reverse().toString();
        tempb = new StringBuilder(tempb).reverse().toString();

        int index = 0, a_length = tempa.length(), b_length = tempb.length();
        String result = "";
        boolean isCarry = false;
        while ( index < a_length || index < b_length ) {
            char ta ;
            if ( index >= a_length )
                ta = '0';
            else
                ta = tempa.charAt(index);
            char tb ;
            if ( index >= b_length )
                tb = '0';
            else
                tb = tempb.charAt(index);
            if ( isCarry ) {
                if ( ta == '1' && tb == '1' ) {
                    result = "1"+result;
                    isCarry = true;
                } else if ( ta == '0' && tb == '0' ) {
                    result = "1"+result;
                    isCarry = false;
                } else {
                    result = "0"+result;
                    isCarry = true;
                }
            } else {
                if ( ta == '1' && tb == '1' ) {
                    result = "0"+result;
                    isCarry = true;
                } else if ( ta == '0' && tb == '0' ) {
                    result = "0"+result;
                    isCarry = false;
                } else {
                    result = "1"+result;
                    isCarry = false;
                }
            }
            index ++;
        }
        if ( isCarry )
            result = "1"+result;
        return Integer.parseInt(result, 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(5,6));
        System.out.println(solution.getSum(99,9));
    }
}