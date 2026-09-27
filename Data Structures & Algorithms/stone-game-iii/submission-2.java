class Solution {
    public int rec(int i,int []stones,int ab){
        if(i>=stones.length){
            return 0;
        }
        if(dp[i][ab]!=null){
            return dp[i][ab];
        }
        int res = ab==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        int score=0;
        for(int j=i;j<=i+2;j++){
            if(j>=stones.length){
                break;
            }
        if(ab==1){
            score+=stones[j];
            res = Math.max(res,score+rec(j+1,stones,0));
        }
        else{
            score-=stones[j];
            res = Math.min(res,score+rec(j+1,stones,1));
        }

        }
        dp[i][ab]=res;
        return res;
        
    }
    Integer dp[][];
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer [stoneValue.length][2];
        int x = rec(0,stoneValue,1);
        if(x==0){
            return "Tie";
        }
        if(x>0){
            return "Alice";
        }
        return "Bob";
    }
}