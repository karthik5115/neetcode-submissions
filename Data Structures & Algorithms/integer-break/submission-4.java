class Solution {
    public int rec(int n){
        if(n==1 || n==0){
            dp[n]=1;
            return dp[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int x =0 ;
        for(int i=1;i<=n;i++){
           x =  Math.max(x,i*rec(n-i));
        }
        dp[n]=x;
        return dp[n];
    }
    int [] dp;
    public int integerBreak(int n) {
     dp = new int[n+1];
     Arrays.fill(dp,-1);
        int x =0;
        for(int i=1;i<n;i++){
            x =  Math.max(x,i*rec(n-i));
        }
        return x;
        
    }
}