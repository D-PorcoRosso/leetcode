package mysource.Solution1963;

public class Solution {
    public int minSwaps_2021_amz(String s) {
        int count = 0;
        for ( int i = 0 ; i < s.length(); i++) {
            if(count > 0 && s.charAt(i) == ']') {
                count--;
            } else if (s.charAt(i) == '[') {
                count++;
            }
        }
        return (count+1)/2;
    }
    public int minSwaps_amz_TLE(String s) {
        int start = 0, end = s.length()-1;
        int count = 0;
        char[] temp = s.toCharArray();
        while (start < end) {
            if (isBalanced(temp)) {
                return count;
            }
            while(start < temp.length/2) {
                if(temp[start] == ']') {
                    break;
                }
                start++;
            }
            
            while(end > temp.length/2) {
                if(temp[end] == '[') {
                    break;
                }
                end--;
            }
            if (start >= end)
                break;
            
            swap(temp, start, end);
            count++;
            start++;
            end--;
        }
        return count;
    }
    
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private boolean isBalanced(char[] array) {
        Stack<Character> stack = new Stack<>();
        for ( char c : array) {
            if (c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
