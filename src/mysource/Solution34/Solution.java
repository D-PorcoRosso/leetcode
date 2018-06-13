package mysource.Solution34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] result = {-1,-1};

        while ( start <= end ) {
            int mid = (start+end)/2;

            if ( target == nums[mid]) {
                //System.out.println(mid);
                int i = mid-1;
                while(i >= 0 && nums[i] == target) i--;
                result[0] = i+1;
                i = mid+1;
                while(i < nums.length && nums[i] == target) i++;
                result[1] = i-1;
                break;
            }

            if ( target < nums[mid] && nums[start] <= nums[mid] )
                end = mid - 1;

            if ( target > nums[mid] && nums[mid] <= nums[end] )
                start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {5,7,7,8,8,10};
        int[] r = solution.searchRange(test1,4);
        System.out.println(r[0] +":"+ r[1]);
        r = solution.searchRange(test1,8);
        System.out.println(r[0] +":"+ r[1]);
        int[] test2 = {8,8,8,8,8,8,8};
        r = solution.searchRange(test2,3);
        System.out.println(r[0] +":"+ r[1]);
        r = solution.searchRange(test2,8);
        System.out.println(r[0] +":"+ r[1]);

            

    }
}