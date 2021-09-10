package mysource.Solution190;

public class Solution {
    public double reverseBits(int n) {
        int[] reverse = new int[32];
        int count = 32;
        double target;
        if (n < 0) {
            target = (double)(Math.pow(2,32) + n);
        } else 
            target = (double)n;
        
        while (count > 0) {
            double current = Math.pow(2,count-1);
            if (target/current >= 1.0) {
                target = target - current;
                reverse[count-1] = 1;
            } else {
                reverse[count-1] = 0;
            }
            count--;
        }
        double sum = 0;
        for ( int i = 32 ; i >= 1 ; i-- ) {
            sum = sum + reverse[i-1] * Math.pow(2,32-i);
        }
        return sum;
    }
}
