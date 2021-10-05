package mysource.Solution134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for ( int i = 0 ; i < gas.length ; i++ ) {
            if (gas[i] - cost[i] >= 0) {
                int sum = gas[i] - cost[i];
                int j = i == gas.length-1 ? 0 : i+1;
                while(sum >= 0) {
                    if (j==i)
                        return i;
                    sum += (gas[j] - cost[j]);
                    if (j == gas.length-1) {
                        j = 0;
                    } else 
                        ++j;
                }
            }
        }
        return -1;
    }
}
