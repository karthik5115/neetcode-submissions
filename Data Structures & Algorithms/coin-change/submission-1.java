class Solution {
    public int coinChange(int[] coins, int amount) {
       int x = rec(0,coins,amount);
       return x==Integer.MAX_VALUE?-1:x;
    }
    public int rec(int i,int[]coins,int amount){
        if(amount==0 ){
            return 0;
        }
        if(amount<0 || i==coins.length){
            return Integer.MAX_VALUE;
        }
        int mul=0,min_coins=Integer.MAX_VALUE;
        while(amount-(coins[i]*mul)>=0){
            int x = rec(i+1,coins,amount-(coins[i]*mul));
            int y = x==Integer.MAX_VALUE?Integer.MAX_VALUE:x+mul;
           min_coins = Math.min(min_coins,y);
           mul++;
        }
        return min_coins;
    }
}
