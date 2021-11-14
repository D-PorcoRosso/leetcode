package mysource.Solution1249;

public class Solution {
    public String minRemoveToMakeValid_2021_google(String s) {
        Stack<Integer> removeIndex = new Stack<>();
        Stack<Character> pStack = new Stack<>();
        boolean containsChar = false;
        for (int i = 0 ; i < s.length() ; i++) {
            switch(s.charAt(i)) {
                case '(':
                    removeIndex.push(i);
                    pStack.push('(');
                    break;
                case ')':
                    if(pStack.isEmpty())
                        removeIndex.push(i);
                    else{
                        removeIndex.pop();
                        pStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        int total = removeIndex.size();
        for (int i = 0 ; i < total ; i++ ) {
            int index = removeIndex.pop();
            
            if(index == s.length()-1)
                s = s.substring(0,index);
            else
                s = s.substring(0,index)+s.substring(index+1,s.length());
        }
        return s;
    }
}
