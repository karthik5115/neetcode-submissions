class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int n = grid.length;
        int m = grid[0].length;
        int [][] visited = new int [n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    System.out.println(i+" "+j);
                    ans = Math.max(ans,bfs(grid,visited,i,j));
                }
            }
        }
        return ans;
        
    }
    public int bfs(int[][]grid,int[][]visited,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]==0){
            return 0;
        }
        visited[i][j]=1;
       return 1+ bfs(grid,visited,i+1,j)+bfs(grid,visited,i,j+1)+bfs(grid,visited,i-1,j)+bfs(grid,visited,i,j-1);
    }
}
