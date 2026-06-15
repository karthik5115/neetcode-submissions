class Solution {
    HashMap<Integer,Integer> dp= new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return rec(-1,cost);
    }
    public int rec(int cur,int []cost){
        if(cur >= cost.length){
            return 0;
        }
        if(dp.containsKey(cur)){
            return dp.get(cur);
        }
        
        int currentStepCost = (cur == -1) ? 0 : cost[cur];
        
        int x = currentStepCost + Math.min(rec(cur+1,cost),rec(cur+2,cost));
        dp.put(cur,x);
        return x;
    }
}