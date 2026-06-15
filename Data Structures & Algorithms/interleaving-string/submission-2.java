class Solution {
    int [][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int[s1.length()][s2.length()];
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        return rec(0,0,s1,s2,s3);
        
    }
    public boolean rec(int i,int j,String s1,String s2,String s3){
            if(i==s1.length() && j==s2.length()){
                return true;
            }
            if(i==s1.length()){
                return s3.substring(i+j,s3.length()).equals(s2.substring(j,s2.length()));
            }
            if(j==s2.length()){
                return s3.substring(i+j,s3.length()).equals(s1.substring(i,s1.length()));
            }
            if(dp[i][j]!=0){
                return dp[i][j]==1;
            }
            if(s1.charAt(i)==s3.charAt(i+j) && s2.charAt(j)==s3.charAt(i+j)){
                boolean x =  rec(i+1,j,s1,s2,s3) || rec(i,j+1,s1,s2,s3);
                dp[i][j] = x?1:-1;
                return x;
            }
            if(s1.charAt(i)==s3.charAt(i+j)){
                boolean x= rec(i+1,j,s1,s2,s3);
                dp[i][j] = x?1:-1;
                return x;
            }
            if(s2.charAt(j)==s3.charAt(i+j)){
                boolean x =  rec(i,j+1,s1,s2,s3);
                dp[i][j] = x?1:-1;
                return x;
            }
            dp[i][j]=-1;
            return false;
    }
}
