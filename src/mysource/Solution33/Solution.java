package mysource.Solution33;

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        if ( end == 0 )
            return nums[0] == target? 0: -1;
        if ( end == 1 ) {
            if (nums[0] == target)
                return 0;
            if (nums[1] == target)
                return 1;
            return -1;
        }

        while( start <= end ) {
            int mid = (start+end)/2;
            if ( nums[mid] == target )
                return mid;

            if ( nums[start] <= nums[mid] ) {
                if ( target < nums[mid] && target >= nums[start] )
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if ( nums[mid] <= nums[end] ) {
                if ( target > nums[mid] && target <= nums[end] )
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public int search_2021(int[] nums, int target) {
        for ( int i = 0 ; i < nums.length ; i++ ){
            if (target == nums[i])
                return i;
        }
        return -1;
    }
    
    public int search_2021_logn(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end-start)/2;
            if (target == nums[mid])
                return mid;
            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid] ) end = mid -1;
                else start = mid +1;
            } else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {0,1,2,3,4,5,6,7,8,9};
        //System.out.print(solution.search(test1,4));
        int[] test2 = {4,5,6,7,0,1,2};
        System.out.println(solution.search(test2,3));
        int[] test3 = {1};
        System.out.println(solution.search(test3,0));
        int[] test4 = {5,1,2,3,4};
        System.out.println(solution.search(test4,1));
        /*int[] test2 = {5,4,3,2,1};
        solution.search(test2);
        for ( int i = 0 ; i < test2.length ; i++ )
            System.out.print(test2[i]+",");*/

    }
}