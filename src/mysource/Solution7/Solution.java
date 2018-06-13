package mysource.Solution7;

import java.util.ArrayList;
class Solution {
    public int reverse(int x) { 
        ArrayList<Integer> reverse  = new ArrayList<>();
        boolean isNeg = false;
        if ( x == -2147483648 )
            return 0;

        if ( x < 0 ){
            isNeg = true;
            x = 0 - x;
        }

        if ( x == 0 ) return 0;
        do {
            if ( x/10 > 0 ) {
                reverse.add(x%10);
                x = x/10;
            } else {
                reverse.add(x%10);
                break;
            }
        } while(true);
        int result = 0, index = 1, length = reverse.size(), branch = 2;
        boolean needToCheck = true;
        if ( length < 10 )
            needToCheck = false;
        for (int i : reverse) {
            if ( needToCheck ) {
                branch = isOverflow(length - index + 1, i);
                if ( branch == 2 )
                    needToCheck = false;
                else if ( branch == 0)
                    return 0;
            }
            result = result + i * (int)(Math.pow(10,(length - index)));
            index++;
        }

        if ( isNeg )
            return 0 - result;

        return result;
    }

    /*
    return 
        0 -> overflow
        1 -> need to check
        2 -> it's ok
    */
    private int isOverflow(int digit, int num) {
        int isOverflow = 2;
        switch(digit){
            case 10:
                if ( num > 2) {
                    isOverflow = 0;
                } else if ( num == 2 ) {
                    isOverflow = 1;
                }
                break;
            case 9:
                if ( num > 1) {
                    isOverflow = 0;
                } else if ( num == 1 ) {
                    isOverflow = 1;
                }
                break;
            case 8:
                if ( num > 4) {
                    isOverflow = 0;
                } else if ( num == 4 ) {
                    isOverflow = 1;
                }
                break;
            case 7:
                if ( num > 7) {
                    isOverflow = 0;
                } else if ( num == 7 ) {
                    isOverflow = 1;
                }
                break;
            case 6:
                if ( num > 4) {
                    isOverflow = 0;
                } else if ( num == 4 ) {
                    isOverflow = 1;
                }
                break;
            case 5:
                if ( num > 8) {
                    isOverflow = 0;
                } else if ( num == 8 ) {
                    isOverflow = 1;
                }
                break;
            case 4:
                if ( num > 3) {
                    isOverflow = 0;
                } else if ( num == 3 ) {
                    isOverflow = 1;
                }
                break;
            case 3:
                if ( num > 6) {
                    isOverflow = 0;
                } else if ( num == 6 ) {
                    isOverflow = 1;
                }
                break;
            case 2:
                if ( num > 4) {
                    isOverflow = 0;
                } else if ( num == 4 ) {
                    isOverflow = 1;
                }
                break;
            case 1:
                if ( num > 7) {
                    isOverflow = 0;
                } else if ( num == 7 ) {
                    isOverflow = 1;
                }
                break;
            default:
                break;
        }
        return isOverflow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse( Integer.parseInt(args[0])));
    }
}