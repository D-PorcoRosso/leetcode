package mysource.Solution161;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        
        if (s.equals(t))
            return false;

        boolean isOneDistance = false;
        
        isOneDistance |= DeleteAndInsert(s, t);
        if (isOneDistance)
            return true;
            
        isOneDistance |= DeleteAndInsert(t, s);
        
        if (isOneDistance)
            return true;

        if (s.length() == t.length()) {
            for ( int i = 0 ; i < s.length() ; i++ ) {
                String tempS, tempT;
                if (i == s.length()-1) {
                    tempS = s.substring(0, i);
                    tempT = t.substring(0, i);
                } else if (i == 0) {
                    tempS = s.substring(i+1, s.length());
                    tempT = t.substring(i+1, t.length());
                } else {
                    tempT = t.substring(0,i)+t.substring(i+1, t.length());
                    tempS = s.substring(0,i)+s.substring(i+1, s.length());
                }
                if (tempS.equals(tempT))
                    return true;
            }
        }
        return false;
    }
            
    private boolean DeleteAndInsert(String source, String target) {
        for ( int i = 0 ; i < source.length() ; i++ ) {
            String temp;
            if (i == 0)
                temp = source.substring(i+1, source.length());
            else if (i == source.length()-1) 
                temp = source.substring(0, i);
            else
                temp = source.substring(0,i)+source.substring(i+1, source.length());
                
            if (target.equals(temp))
                return true;
        }
        return false;
    }
}
