class Solution {
    int [][] visited;
    public int uniquePathsWithObstacles(int[][] grid) {
        visited= new int[grid.length][grid[0].length];
        for(int[] row:visited){
            Arrays.fill(row,-1);
        }
        return rec(0,0,grid);
    }

    public int rec(int i,int j,int[][] grid){
        if(i>=grid.length || i<0 || j<0 || j>=grid[0].length || grid[i][j]==1){
            return 0;
        }
        if(visited[i][j]!=-1){
            // visited[i][j]++;
            return visited[i][j];
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        // visited[i][j]=1;
        int bot = rec(i+1,j,grid);
        int rig = rec(i,j+1,grid);
        visited[i][j]=bot+rig;
        return bot+rig;
    }
}