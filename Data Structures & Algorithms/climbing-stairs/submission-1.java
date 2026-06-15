class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n+2];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        dp[n]=1;
        dp[n+1]=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }

        return dp[0];
        
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
