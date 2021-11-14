package mysource.Solution739;

public class Solution {
    public int[] dailyTemperatures_2021_google(int[] temperatures) {
        int[] results = new int[temperatures.length];
        for (int i = temperatures.length-2 ; i >= 0 ; i--) {
            for ( int j = i+1 ; j < temperatures.length ; j++) {
                if(temperatures[i] < temperatures[j]) {
                    results[i] = j-i;
                    break;
                }
            }
        }
        return results;
    }
}
