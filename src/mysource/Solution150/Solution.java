package mysource.Solution150;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for ( int i = 0 ; i < tokens.length ; i++ ) {
            String s = tokens[i];
            int nums1, nums2, temp;
            switch(s) {
                case "+":
                    nums1 = stack.pop();
                    nums2 = stack.pop();
                    temp = nums2+nums1;
                    stack.push(temp);
                    break;
                case "-":
                    nums1 = stack.pop();
                    nums2 = stack.pop();
                    temp = nums2-nums1;
                    stack.push(temp);
                    break;
                case "*":
                    nums1 = stack.pop();
                    nums2 = stack.pop();
                    temp = nums2*nums1;
                    stack.push(temp);
                    break;
                case "/":
                    nums1 = stack.pop();
                    nums2 = stack.pop();
                    temp = nums2/nums1;
                    stack.push(temp);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}
