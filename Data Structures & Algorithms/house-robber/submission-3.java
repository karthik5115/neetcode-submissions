class Solution {
    int [] dp;
    public int rob(int[] nums) {
        dp = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=-1;
        }
        return Math.max(rec(0,nums),rec(1,nums));
        
    }
    public int rec(int h,int []nums){
        if(h>=nums.length){
            return 0;
        }

        if(dp[h]!=-1){
            return dp[h];

        }
        int max_i=0;
        max_i = Math.max(rec(h+2, nums), rec(h+3, nums));
        return dp[h] = nums[h]+max_i;
    }
}

