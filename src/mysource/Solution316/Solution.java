package mysource.Solution316;

public class Solution {
    public String removeDuplicateLetters_2021_250(String s) {
        Stack<Character> stack = new Stack<>();
        char[] latters = s.toCharArray();
        for ( int i = 0 ; i < latters.length ; i++ ) {
            if (stack.contains(latters[i]))
                continue;
            while(!stack.isEmpty() && stack.peek() > latters[i] && 
               isExistLater(latters, stack.peek(), i+1)) {
                stack.pop();
            }
                
            stack.push(latters[i]);
        }
        Iterator<Character> it = stack.iterator();
        StringBuilder builder = new StringBuilder();
        while(it.hasNext()) {
            builder.append(it.next());
        }
        return builder.toString();
    }
    
    private boolean isExistLater(char[] latters, char target, int start) {
        for ( int i = start ; i < latters.length ; i++ ) {
            if (target == latters[i])
                return true;
        }
        return false;
    }
}
