class Solution {
    int [][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j]=-1;
            }
        }
       return rec(0,0,s,t);
    }
    public int rec(int i,int j,String s, String t){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
          ans+=  rec(i+1,j+1,s,t);
        }
       ans+= rec(i+1,j,s,t);
       return dp[i][j]=ans;
    }
}
