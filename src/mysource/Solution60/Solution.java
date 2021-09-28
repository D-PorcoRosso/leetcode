package mysource.Solution60;/*
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
    public String getPermutation_2021_250(int n, int k) {
        int[] input = new int[n];
        for ( int i = 0 ; i < n ; i++ ) {
            input[i] = i+1;
        }
        while(k > 1) {
            findPermutation(input);
            k--;
        }
        StringBuilder builder = new StringBuilder();
        for ( int i = 0 ; i < n ; i++ ) {
            builder.append(input[i]);
        }
        
        return builder.toString();
    }
    
    private void findPermutation(int[] input) {
        for ( int i = input.length - 2; i >= 0 ; i-- ) {
            if (input[i] < input[i+1]) {
                int min = Integer.MAX_VALUE, index = i+1;
                for ( int j = index ; j < input.length ; j++ ) {
                    if ( input[i] < input[j] ) {
                        min = Math.min(input[j], min);
                        index = j;
                    }
                }
                swap(input, i, index);
                reverse(input, i+1);
                break;
            }
        }
    }
    
    private void reverse(int[] input, int start) {
        int j = input.length-1;
        while (start < j) {
            swap(input, start, j);
            start++;
            j--;
        }
    }
    
    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

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