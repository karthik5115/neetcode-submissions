class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
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
        return ans;
        
    }
}
