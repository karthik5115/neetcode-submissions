class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
        dp = new int[matrix.length][matrix[0].length];
         for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
               dp[i][j]=-1;
            }
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
               ans = Math.max(ans,1+rec(i,j,matrix));
            }
        }
        return ans;
    }
    public int rec(int i,int j,int [][] matrix){
        if(i<0 || j<0 || i>=matrix.length || j>= matrix[0].length){
            return 0;
        }
        int ans = 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i+1<matrix.length && matrix[i+1][j]>matrix[i][j]){
            ans = Math.max(ans,1+rec(i+1,j,matrix));
        }
         if(j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]){
            ans = Math.max(ans,1+rec(i,j+1,matrix));
        }
         if(i-1>=0 && matrix[i-1][j]>matrix[i][j]){
            ans = Math.max(ans,1+rec(i-1,j,matrix));
        }
         if(j-1>=0 && matrix[i][j-1]>matrix[i][j]){
            ans = Math.max(ans,1+rec(i,j-1,matrix));
        }
        return dp[i][j]=ans;
        
    }
}
