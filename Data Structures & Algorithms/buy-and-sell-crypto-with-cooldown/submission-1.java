class Solution {
    int [][] dp;
    public int maxProfit(int[] prices) {
         dp = new int [prices.length+1][prices.length+1];
         for(int i=0;i<prices.length+1;i++){
            for(int j=0;j<prices.length+1;j++){
                dp[i][j]=-1;
            }
         }
        return rec(-1,0,prices);
    }
    public int rec(int prev,int curr,int []prices){
        if(curr>=prices.length){
            return 0;
        }
        if(dp[prev+1][curr+1]!=-1){
            return dp[prev+1][curr+1];
        }
        int profit=-1;
        if(prev!=-1){
             profit = (prices[curr]-prices[prev])+rec(-1,curr+2,prices);
        }
        else{
            profit = rec(curr,curr+1,prices);
        }
        
        return dp[prev+1][curr+1] =  Math.max(profit,rec(prev,curr+1,prices));
       
    }
}
