package mysource.Solution38;

class Solution {
    public String countAndSay_2021_250(int n) {
        String result = "1";
        if (n == 1) {
            return result;
        }
        
        result = "11";
        if (n == 2) {
            return result;
        }
        
        int index = 2;
        while ( index < n ) {
            result = parseString(result);
            index++;
        }
        return result;
    }
    
    private String parseString (String str) {
        char[] arr = str.toCharArray();
        String result = "";
        int count = 1;
        int currentNum = Character.getNumericValue(arr[0]);
        StringBuilder builder = new StringBuilder();
        for ( int i = 1 ; i < arr.length ; i++ ) {
            if (currentNum == Character.getNumericValue(arr[i])) {
                count++;
            } else {
                builder.append(result);
                builder.append(count);
                builder.append(currentNum);
                currentNum = Character.getNumericValue(arr[i]);
                count = 1;
                if (i == arr.length -1) {
                    builder.append(result);
                    builder.append(count);
                    builder.append(currentNum);
                }
            }
        }
        if (count != 1) {
            builder.append(result);
            builder.append(count);
            builder.append(currentNum);
        }
        
        return builder.toString();
    }

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