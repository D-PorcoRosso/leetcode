package mysource.Solution202;

public class Solution {
    public boolean isHappy_2021_250(int n) {
        List<Integer> temp = new ArrayList<>();

        while (n != 1) {
            temp.add(n);
            n = nextNum(n);
            if (temp.contains(n))
                return false;
        }
        
        return true;
    }
    
    private int nextNum(int n) {
        int count = n;
        int happySum = 0;
        while (count > 0) {
            happySum = happySum + ((count%10)*(count%10));
            count /= 10;
        }
        return happySum;
    }
}
