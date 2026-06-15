class Solution {
    int [][]  dp;
    public int longestCommonSubsequence(String text1, String text2) {
         dp = new int [text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                dp[i][j]=-1;
            }
        }
        int i=text1.length()-1,j=text2.length()-1;
        return rec(i,j,text1,text2);
    }
    public int rec(int i,int j,String text1, String text2){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+rec(i-1,j-1,text1,text2);
         }
         return dp[i][j]=Math.max(rec(i-1,j,text1,text2),rec(i,j-1,text1,text2));
    }
}
