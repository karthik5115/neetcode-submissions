class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        dp = new int[2][piles.length][2*piles.length];
        for(int i=0;i<piles.length;i++){
            Arrays.fill(dp[0][i],-1);
            Arrays.fill(dp[1][i],-1);
        }
        return rec(0,0,1,piles);
    }
    public int rec(int alice,int i,int m,int[]piles){
        if(i>=piles.length){
            return 0;
        }
        int ans=0;
        if(dp[alice][i][m]!=-1){
            return dp[alice][i][m];
        }
        int res = alice == 0 ? 0 : Integer.MAX_VALUE;
        for(int j=1;j<=2*m;j++){
            if(i+j>piles.length){break;}
            ans+=piles[i+j-1];
            if(alice==0){
            res = Math.max(res,ans+rec(1,i+j,Math.max(j,m),piles));
            }
            else{
                res = Math.min(res,rec(0,i+j,Math.max(j,m),piles));
            }
        }
        return dp[alice][i][m]=res;
    }
}