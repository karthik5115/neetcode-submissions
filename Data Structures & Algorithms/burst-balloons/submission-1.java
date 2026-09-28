class Solution {
    int [][] dp;
    public int maxCoins(int[] nnums) {
        int [] nums = new int[nnums.length+2];
        nums[0]=1;
        nums[nums.length-1]=1;
        for(int i=0;i<nnums.length;i++){
            nums[i+1]=nnums[i];
        }
        dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(1,nums.length-2,nums);
    }
    public int rec(int l,int r,int[]nums){
        if(l>r){
            return 0;
        }
        
        int maxx = Integer.MIN_VALUE;
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        for(int i=l;i<=r;i++){
            int coins = nums[l-1] * nums[i] * nums[r+1];
            coins += rec(l,i-1,nums) +rec(i+1,r,nums);
            maxx = Math.max(maxx,coins);

        }
        return dp[l][r]=maxx;
    }
}
