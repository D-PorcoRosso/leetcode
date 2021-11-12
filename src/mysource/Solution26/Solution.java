package mysource.Solution26;

class Solution {
    public int removeDuplicates_2021_google(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int start = 0, end = start+1;
        int index = 0;
        while(end < nums.length) {
            while(end < nums.length && nums[start] == nums[end]) {
                end++;
            }
            nums[index] = nums[start];
            index++;
            start = end;
            end = start+1;
        }
        if (start < nums.length) {
            nums[index] = nums[start];
            return index+1;
        }
        return index;
    }

    public int removeDuplicates_2021_250(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int targetIndex = 0, target = nums[0], count = 1, j = 1;
        boolean isDuplicate = false;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            if (target == nums[i] ) {
                if (!isDuplicate) {
                    isDuplicate = true;
                }
            } else {
                nums[j] = nums[i];
                target = nums[i];
                count++;
                j++;
                isDuplicate = false;
            }
        }
        return count;
    }

    public int removeDuplicates(int[] nums) {
        if ( nums.length == 0 )
            return 0;
        int index = 0;
        int count = 1;
        for ( int i = 1 ; i < nums.length ; i++ ) {
            if ( nums[index] != nums[i] ) {
                index++;
                count++;
                nums[index] = nums[i];
            }
        }
        return count;
    }

    private static void print(int[] input) {
        for ( int i : input ) {
            System.out.print(i+",");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t1 = {1,1,1};
        int[] t2 = {};
        int[] t3 = {1};
        int[] t4 = {1,2,3,4,5,6,7,8,9};
        int[] t5 = {1,2,3,4,5,6,7,8,8,8,8,8};
        int[] t6 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution.removeDuplicates(t1));
        print(t1);
        System.out.println(solution.removeDuplicates(t2));
        print(t2);
        System.out.println(solution.removeDuplicates(t3));
        print(t3);
        System.out.println(solution.removeDuplicates(t4));
        print(t4);
        System.out.println(solution.removeDuplicates(t5));
        print(t5);
        System.out.println(solution.removeDuplicates(t6));
        print(t6);
    }
}