package mysource.Solution67;

class Solution {
    public String addBinary_2021_250(String a, String b) {
        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }
        
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        
        boolean carry = false;
        int bIndex = arrayB.length-1;
        for ( int i = arrayA.length - 1 ; i >= 0 ; i-- ) {
            if (bIndex >= 0) {
                if (arrayB[bIndex] == '1' && arrayA[i] == '1') {
                    if (carry) {
                        arrayA[i] = '1';
                    } else 
                        arrayA[i] = '0';
                    carry = true;
                } else if (arrayB[bIndex] == '0' && arrayA[i] == '0') {
                    if (carry) {
                        arrayA[i] = '1';
                    }
                    carry = false;
                } else {
                    if (carry) {
                        arrayA[i] = '0';
                        carry = true;
                    } else {
                        arrayA[i] = '1';
                        carry = false;
                    }
                }
                bIndex--;
            } else {
                if (carry) {
                    if (arrayA[i] == '1')
                        arrayA[i] = '0';
                    else {
                        arrayA[i] = '1';
                        carry = false;
                        break;
                    }
                } else {
                    carry = false;
                    break;
                }
            }
        }
        if (carry) {
            char[] result = new char[arrayA.length + 1];
            result[0] = '1';
            for ( int i = 0 ; i < arrayA.length ; i++) {
                result[i+1] = arrayA[i];
            }
            return String.valueOf(result);
        }
        
        return String.valueOf(arrayA);
    }

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