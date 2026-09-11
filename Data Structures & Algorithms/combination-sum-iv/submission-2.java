class Solution {
    public int rec(int nums[],int target){
        if(target==0){
            return 1;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int count=0;
        for(int j=0;j<nums.length;j++){
           if(target-nums[j]>=0){
            count+=rec(nums,target-nums[j]);
           }
            }
            dp[target]=count;
        return dp[target];
    }
    int [] dp ;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        Arrays.sort(nums);
        return rec(nums,target);
        
    }
}