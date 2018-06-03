import java.util.*;

class Solution {

    private class Status {

        Status(boolean isVisit, boolean status) {
            this.isVisit = isVisit;
            this.status = status;
        }
        public final boolean isVisit;
        public final boolean status;
    }

    public boolean canJump(int[] nums) {
        Status[] status = new Status[nums.length];
        return isExist(0,nums,status);
    }

    private boolean isExist(int index, int[] nums, Status[] status) {
        int length = nums.length;
        
        if (status[index] != null && status[index].isVisit){
            //System.out.println(index+":"+status[index].status);
            return status[index].status;
        }
        //System.out.println(index+":"+nums[index]);
        if ( index == length - 1 ) {
            Status indexStatus = new Status(true,true);
            status[index] = indexStatus;
            return true;
        }
        if ( nums[index] == 0 ) {
            Status indexStatus = new Status(true,false);
            status[index] = indexStatus;
            return false;
        }
        boolean isExist = false;
        for ( int i = 1 ; i <= nums[index] ; i++ ) {
            if ( index+i < length ) {
                isExist |= isExist(index+i, nums,status);
                Status indexStatus = new Status(true,isExist);
                status[index] = indexStatus;
            }
            if (isExist)
                return isExist;
        }
        return isExist;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2,3,1,1,4};
        System.out.println(solution.canJump(test1));
        int[] test2 = {3,2,1,0,4};
        System.out.println(solution.canJump(test2));
    }
}