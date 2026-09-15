class Solution {
    int [] [] dp ;
    public int minPathSum(int[][] grid) {
       dp = new int[grid.length][grid[0].length];
       for(int []row:dp){
        Arrays.fill(row,-1);
       }
       return  rec(0,0,grid);
    }
    public int rec(int i,int j,int[][] grid){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        int bot = rec(i+1,j,grid);
        int right = rec(i,j+1,grid);
//System.out.println(bot + " "+ right+" "+grid[i][j]);
        int min = Math.min(bot,right);
        min = min==Integer.MAX_VALUE ? Integer.MAX_VALUE : grid[i][j]+min;
        return dp[i][j]=min;
    }
}