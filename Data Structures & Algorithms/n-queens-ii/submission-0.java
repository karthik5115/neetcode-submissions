class Solution {
    int sum[] = new int[1];
    public int totalNQueens(int n) {
        int [][] visited = new int [n][n];
        rec(0,visited,n);
        return sum[0];
    }
    public void rec(int r,int [][]visited,int n){
        if(r==visited.length){
            sum[0]++;
            return;
        }
        for(int c=0;c<n;c++){
            if(isSafe(r,c,visited,n)){
                visited[r][c]=1;
                rec(r+1,visited,n);
                visited[r][c]=0;
            }
        }
    }
    public boolean isSafe(int r, int c, int[][] visited, int n) {
    for (int i = 0; i < r; i++) {
        if (visited[i][c] == 1) return false;
    }
    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
        if (visited[i][j] == 1) return false;
    }
    for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
        if (visited[i][j] == 1) return false;
    }
    return true;
}

}
