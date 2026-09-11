class Solution {
    public int rec(int n,int [] dp){
        if(n<=0){
            dp[0]=0;
            return dp[0];
        }
        if(n==1 || n==2){
            dp[n]=1;
            return dp[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=rec(n-1,dp)+rec(n-2,dp)+rec(n-3,dp);
        return dp[n];
    }
    public int tribonacci(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        rec(n,dp);
        return dp[n];
    }
}