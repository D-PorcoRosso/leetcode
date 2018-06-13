import java.util.*;

/*
    public String getPermutation(int n, int k) {
        int[] facts = new int[n + 1];
        Arrays.fill(facts, 1);
        List<Integer> l = new ArrayList<>();
        facts[0] = 1;
        for (int i = 1; i <= n; i++) {
            facts[i] *= facts[i - 1] * i;
            l.add(i);
        }
        
        StringBuilder builder = new StringBuilder();
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / facts[n - i];
            builder.append(l.get(index));
            l.remove(index);
            k -= index * facts[n - i];
        }
        return builder.toString();
    }*/

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder builder = new StringBuilder();
        int[] array = new int[n];
        for ( int i = 1; i <=n ; i++ ) array[i-1]=i;
        int n_1 = 0;
        k = k-1;
        while ( n > 0 ) {
            n_1 = n-1;
            int n_1_factorial = 1;
            while(n_1 > 0) {
                n_1_factorial *= n_1;
                n_1--;
            }
            int index = k/n_1_factorial;
            builder.append(array[index]);
            System.out.println("n:"+n+" k:"+k+" n_1_factorial:"+n_1_factorial);
            k = k % n_1_factorial;
            int[] newarray = new int[n-1];
            for ( int i = 0,  j = 0; i < n ; i++ ) {
                if ( i != index ) {
                    newarray[j]= array[i];
                    System.out.print(newarray[j]+",");
                    j++;
                }
            }
            System.out.println();
            array = newarray;
            n--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(4,9));
        System.out.println(solution.getPermutation(4,24));
        System.out.println(solution.getPermutation(4,1));
        System.out.println(solution.getPermutation(4,12));
    }
}