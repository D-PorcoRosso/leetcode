package mysource.Solution318;

public class Solution {
    public int maxProduct_2021_250(String[] words) {
        int max = 0;
        for ( int i = 0 ; i < words.length ; i++ ) {
            for ( int j = i+1 ; j < words.length ; j++) {
                if (!isShareCommonLetters(words[i], words[j])) {
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    
    private boolean isShareCommonLetters(String a, String b) {
        HashSet<Character> container = new HashSet<>();
        for ( int i = 0 ; i < a.length() ; i++ ) {
            container.add(a.charAt(i));
        }
        
        for ( int i = 0 ; i < b.length() ; i++ ) {
            if(container.contains(b.charAt(i)))
                return true;
        }
        return false;
    }
}
