package mysource.Solution66;

class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        double result = 0;
        int index = 0;
        for (int i = length -1 ; i >= 0 ; i--) {
            result += (Math.pow(10, index) * digits[i]);
            index++;
        }
        result++;
        System.out.println(result);
        index--;
        if ( result/Math.pow(10, index) == 10d)
            index++;
        int[] resultArray = new int[index+1];
        int limit = index+1;
        for ( int i = 0 ; i < limit; i++) {
            double mod = Math.pow(10, index);
            
            resultArray[i] = (int) (result/mod);
            System.out.println(result/mod+":"+mod);
            result = result%mod;
            index--;
        }
        return resultArray;
    }

    public int[] plusOne1(int[] digits) {
        boolean needNewArray = false;
        int index = digits.length - 1;
        while(true) {
            int temp = digits[index] + 1;
            if ( temp == 10 ) 
                digits[index] = temp - 10;
            else {
                digits[index] = temp;
                break;
            }
            index--;
            if ( index == -1 ) {
                needNewArray = true;
                break;
            }
        }
        if ( needNewArray ) {
            int[] newResult = new int[digits.length+1];
            newResult[0] = 1;
            for ( int i = 1 ; i < digits.length+1 ; i++) {
                newResult[i] = digits[i-1];
            }
            return newResult;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {8};
        int[] test2 = {9,9};
        int[] test3 = {0};
        int[] test4 = {1,2,3,4};
        int[] test5 = {9,8,7,6,5,4,3,2,1,0};
        int[] test6 = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        print(solution.plusOne1(test1));
        print(solution.plusOne1(test2));
        print(solution.plusOne1(test3));
        print(solution.plusOne1(test4));
        print(solution.plusOne1(test5));
        print(solution.plusOne1(test6));
        
    }

    private static void print(int[] test) {
        for (int t : test)
            System.out.print(t+",");
        System.out.println("\n");
    }
}