class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
      int x = rec(0,coins,amount);
       return x;
    }
    public int rec(int i,int[]coins,int amount){
        if(amount==0 ){
            return 1;
        }
        if(amount<0 || i==coins.length){
            return 0;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int mul=0,ans=0;
        while(amount-(coins[i]*mul)>=0){
            int x = rec(i+1,coins,amount-(coins[i]*mul));
            ans+=x;
           mul++;
        }
        return dp[i][amount]=ans;
    }
}
