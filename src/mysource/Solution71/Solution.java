package mysource.Solution71;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public String simplifyPath_2021_250(String path) {
        Stack<String> stack = new Stack();
        String[] paths = path.split("/");
        
        for ( String p : paths ) {
            switch(p) {
                case ".":
                    continue;
                case "..":
                    if (!stack.empty())
                        stack.pop();
                    break;
                case "":
                    continue;
                default:
                    stack.push(p);
                    break;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        if (stack.empty())
            builder.append("/");
        for ( String p : stack ) {
            builder.append("/");
            builder.append(p);
        }
        return builder.toString();
    }

    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder();
        Queue<String> folderName = new LinkedList<>();
        int dividerCount = 0, length = path.length();

        for ( int i = 0 ; i < path.length() ; i++ ) {
            char current = path.charAt(i);
            if ( i == 0 )
                if ( current == '/' ) {
                    dividerCount++;
                    continue;
                }
                    
            switch(current) {
                case '/':
                    if ( builder.length() != 0 ) {
                        folderName.add(builder.toString());
                        builder.setLength(0);
                        dividerCount++;
                    }
                    break;
                case '.':
                    if ( i+1 < length ) {
                        char compare = path.charAt(i+1);
                        if ( compare == '.' ) {
                            folderName.poll();
                            dividerCount--;
                        } else if ( compare == '/') {
                            i++;
                        }
                    }
                    break;
                default:
                    builder.append(current);
                    break;
            }
        }
        builder.setLength(0);
        if ( folderName.size() == 0 )
            builder.append("/");
        while(folderName.size() != 0) {
            builder.append("/");
            builder.append(folderName.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/"));
    }
}