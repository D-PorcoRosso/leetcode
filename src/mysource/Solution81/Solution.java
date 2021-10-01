package mysource.Solution81;

class Solution {
    public boolean search_2021_250(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end-start)/2+start;
            if (target == nums[mid])
                return true;
            if (nums[start] < nums[mid]) {
                if (target < nums[mid])
                    end = mid-1;
                else
                    start = mid+1;
            } else if (nums[start] > nums[mid]){
                if (target > nums[mid])
                    start = mid+1;
                else
                    end = mid-1;
            } else {
                for ( int i = 0 ; i < nums.length ; i++ ) {
                    if (target == nums[i])
                        return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        for ( int i = 0 ; i < nums.length ; i++ ) 
            if (target == nums[i])
                return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {4,5,6,7,8,9,0,0,0,1,2};
        System.out.println(solution.search(test1,0));
        int[] test2 = {1,1,3,1};
        System.out.println(solution.search(test2,1));
        int[] test3 = {1,3,1,1,1};
        System.out.println(solution.search(test3,0));

    }
}