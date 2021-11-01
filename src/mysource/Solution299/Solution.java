package mysource.Solution299;

public class Solution {
    public String getHint_2021_250(String secret, String guess) {
        char[] secArray = secret.toCharArray();
        char[] gusArray = guess.toCharArray();
        boolean[] secVisited = new boolean[secArray.length];
        boolean[] gusVisited = new boolean[secArray.length];
        int A = 0, B = 0;
        
        for (int i = 0 ; i < secArray.length ; i++ ) {
            for (int j = 0 ; j < gusArray.length ; j++ ) {
                if (secArray[i]==gusArray[j] && i == j) {
                    A++;
                    secVisited[i] = true;
                    gusVisited[i] = true;
                }
            }
        }
        
        for (int i = 0 ; i < secArray.length ; i++ ) {
            for (int j = 0 ; j < gusArray.length ; j++ ) {
                if (secArray[i]==gusArray[j] && !secVisited[i] && !gusVisited[j]) {
                    B++;
                    secVisited[i] = true;
                    gusVisited[j] = true;
                }
            }
        }
        return A+"A"+B+"B";
    }
}
