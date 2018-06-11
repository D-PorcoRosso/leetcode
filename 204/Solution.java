import java.util.*;

class Solution {
    public int countPrimes(int n) {
        if ( n == 0 || n == 1 || n == 2 )
            return 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for ( int i = 3 ; i < n ; i++ ) {
            for ( int j = 0 ; j < primes.size() ; j++ ) {
                if ( i % primes.get(j) == 0 ) {
                    break;
                } else {
                    if ( j == (primes.size() - 1) ) {
                        primes.add(i);
                    }
                }
            }
        }
        System.out.println(primes);
        return primes.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(499979));

    }
}