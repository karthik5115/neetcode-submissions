class Solution {
    public int maxProfit(int[] prices) {
        return rec(-1,0,prices);
    }
    public int rec(int prev,int curr,int []prices){
        if(curr>=prices.length){
            return 0;
        }
        int profit=-1;
        if(prev!=-1){
             profit = (prices[curr]-prices[prev])+rec(-1,curr+2,prices);
        }
        else{
            profit = rec(curr,curr+1,prices);
        }
        
        return Math.max(profit,rec(prev,curr+1,prices));
       
    }
}
