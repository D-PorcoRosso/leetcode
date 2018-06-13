package mysource.Solution38;

class Solution {
    public String countAndSay(int n) {
        if ( n == 0 )
            return "";
        if ( n == 1 )
            return "1";
        String returnString = "11";
        for ( int i = 1 ; i < n - 1 ; i++ ) {
            char[] array = returnString.toCharArray();
            StringBuilder builder = new StringBuilder();
            int count = 0;
            char pre = array[0];
            for ( int j = 0 ; j < array.length ; j++ ) {
                if ( array[j] == pre ) {
                    count++;
                } else {
                    builder.append(count);
                    builder.append(pre);
                    count = 1;
                    pre = array[j];
                }
            }
            if ( count != 0 ) {
                builder.append(count);
                builder.append(pre);
            }
            returnString = builder.toString();
            System.out.println(returnString);
        }
        return returnString;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    
        System.out.println(solution.countAndSay(10));
        //6 -> 2111121211
    }
}