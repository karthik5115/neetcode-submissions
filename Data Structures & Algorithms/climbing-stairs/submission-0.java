class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return rec(0,n,dp);
        
    }
     public int rec(int curr,int n,int[] dp){
        if(curr>n){
            return 0;
        }
        if(curr==n){
            return 1;
        }
        if(dp[curr]!=-1){
            return dp[curr];
        }
        return dp[curr]=rec(curr+1,n,dp)+rec(curr+2,n,dp);

     }
}
