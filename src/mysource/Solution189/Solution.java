package mysource.Solution189;

public class Solution {

    public void rotate_googleprepare(int[] nums, int k) {
        if(nums.length == 1)
            return;
        if(k >= nums.length) {
            k = k%nums.length;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = nums.length, index = count-k;
        while (count > 0) {
            if(index == nums.length) {
                index = 0;
            }
            queue.offer(nums[index]);
            index++;
            count--;
        }
        index = 0;
        while(!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }
    }

    public void rotate_tle(int[] nums, int k) {
        while (k > 0) {
            k--;
            int temp = nums[nums.length-1];
            for (int i = nums.length-1 ; i > 0 ; i-- ) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }
    }

    public void rotate_2021_250(int[] nums, int k) {
        if (nums.length == 1)
            return;
        if (k > nums.length) {
            k = k%nums.length;
        }
        for ( int i = 0 ; i < nums.length/2 ; i++ ) {
            swap(nums, i, nums.length-1-i);
        }
        for (int i = 0 ; i < k/2 ; i++) {
            swap(nums, i, k-1-i);
        }
        
        for (int i = k ; i < (nums.length-k)/2 + k ; i++) {
            swap(nums, i, nums.length-1+k-i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
