package mysource.Solution496;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length];
        for ( int i = 0 ; i < nums1.length ; i++ ) {
            boolean isFindTheSameOne = false;
            for ( int j = 0 ; j < nums2.length ; j++ ) {
                if (isFindTheSameOne) {
                    if ( nums1[i] < nums2[j] ) {
                        result[i] = nums2[j];
                        break;
                    } else
                        if ( j == nums2.length -1 )
                            result[i] = -1;
                } else {
                    if ( nums1[i] == nums2[j] ) {
                        isFindTheSameOne = true;
                        if( j == nums2.length - 1)
                            result[i] = -1;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {4,1,2};
        int[] test2 = {1,3,4,2};
        int[] result = solution.nextGreaterElement(test1,test2);
        for ( int i : result ) {
            System.out.println(i);
        }
        int[] test3 = {2,4};
        int[] test4 = {1,2,3,4};
        result = solution.nextGreaterElement(test3,test4);
        for ( int i : result ) {
            System.out.println(i);
        }
    }
}