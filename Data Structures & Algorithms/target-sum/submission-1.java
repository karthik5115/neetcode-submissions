class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums,target,0,0);
    }
    public int rec(int[] nums, int target,int i,int tsum){
        if(i==nums.length){
            if(tsum==target){
                return 1;
            }
            return 0;
        }
        
        return rec(nums,target,i+1,tsum-nums[i]) + rec(nums,target,i+1,tsum+nums[i]);
    }
}
