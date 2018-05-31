class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        boolean isNeedCarry = false;

        StringBuilder builder = new StringBuilder();
        while(aIndex >= 0 && bIndex >= 0) {
            if ( aArray[aIndex] == '1' && bArray[bIndex] == '1' ) {
                if ( isNeedCarry )
                    builder.append(1);
                else
                    builder.append(0);
                isNeedCarry = true;
            } else if ( aArray[aIndex] == '0' && bArray[bIndex] == '0' ) {
                if ( isNeedCarry )
                    builder.append(1);
                else
                    builder.append(0);
                isNeedCarry = false;
            } else {
                if ( isNeedCarry ) {
                    builder.append(0);
                    isNeedCarry = true;
                } else {
                    builder.append(1);
                    isNeedCarry = false;
                }
            }
            aIndex--;
            bIndex--;
        }
        int restIndex = aIndex > bIndex ? aIndex : bIndex;
        char[] restArray = aIndex > bIndex ? aArray : bArray;
        while ( restIndex >= 0 ) {
            if ( isNeedCarry ) {
                if ( restArray[restIndex] == '1' ) {
                    builder.append(0);
                    isNeedCarry = true;
                } else {
                    builder.append(1);
                    isNeedCarry = false;
                }
            } else {
                builder.append(restArray[restIndex]);
            }
            restIndex--;
        }
        if ( isNeedCarry ) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11","1"));
        System.out.println(solution.addBinary("1010","1011"));
        System.out.println(solution.addBinary("1111","0"));
        System.out.println(solution.addBinary("111111","1"));
    }
}