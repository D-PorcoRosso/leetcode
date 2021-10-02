package mysource.Solution88;

class Solution {
    public void merge_2021_250_fast(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] nums = new int[m+n];
        int index = 0, i = 0, j = 0;
        
        while (i < m || j < n) {
            if (i == m) {
                nums[index] = nums2[j++]; 
            } else if (j == n) {
                nums[index] = nums1[i++];
            } else {
                if (nums1[i] > nums2[j]) {
                    nums[index] = nums2[j++];
                } else {
                    nums[index] = nums1[i];
                    i++;
                }
            }
            ++index;
        }
        
        for ( i = 0 ; i < m+n ; i++ ) {
            nums1[i] = nums[i];
        }
    }
    public void merge_2021_250(int[] nums1, int m, int[] nums2, int n) {
        for ( int i = m ; i < m+n ; i++ ) {
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if ( n == 0 )
            return;

        if ( m == 0 ) {
            for ( int i = 0 ; i < nums1.length ; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        if ( m == 1 && nums1[0] == 0) {
            for ( int i = 0 ; i < nums1.length ; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,2,3,0,0,0};
        int[] t2 = {2,5,6};
        //solution.merge(t1, 3, t2, 3);
        for ( int i = 0 ; i < t1.length ; i++ ) {
            //System.out.println(t1[i]);
        }
        int[] t3 = {0};
        int[] t4 = {1};
        solution.merge(t3, 0, t4, 1);
        for ( int i = 0 ; i < t3.length ; i++ ) {
            System.out.println(t3[i]);
        }

        int[] t5 = {4,0,0,0,0,0};
        int[] t6 = {1,2,3,5,6};
        solution.merge(t5, 1, t6, 5);
        for ( int i = 0 ; i < t5.length ; i++ ) {
            System.out.println(t5[i]);
        }
        
    }
}