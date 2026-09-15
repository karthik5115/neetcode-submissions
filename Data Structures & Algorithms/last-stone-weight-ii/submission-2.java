class Solution {
    int[][] dp;
    public int lastStoneWeightII(int[] stones) {
        
        int stoneSum = 0;
        for (int stone : stones) {
            stoneSum += stone;
        }
        dp=new int[stones.length][stoneSum];
        for(int[]x:dp){
            Arrays.fill(x,-1);
        }
        int target = (stoneSum + 1) / 2;
        
        return rec(0,0,stones,stoneSum,target);
        
    }
    public int rec(int i,int sum,int []stones,int total,int target){
        if(i>=stones.length || sum>=target){
            return Math.abs(sum-(total-sum));
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int x = rec(i+1,sum,stones,total,target);
        int y = rec(i+1,sum+stones[i],stones,total,target);
        return dp[i][sum]=Math.min(x,y);
    }
}