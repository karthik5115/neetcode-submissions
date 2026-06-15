class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans[] = {false};
        int [][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                 rec(i,j,0,board,word,visited,ans);
                if(ans[0]){
                    return true;
                }
            }
        }
       
        return false;
    }
    public void rec(int i,int j,int k,char [][]board,String word,int [][] visited,boolean []ans){
        if(k==word.length()){
            ans[0]=true;
            return;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || visited[i][j]==1 || word.charAt(k)!=board[i][j]){
            return;
        }
        visited[i][j]=1;
        rec(i+1,j,k+1,board,word,visited,ans);
        rec(i,j+1,k+1,board,word,visited,ans);
        rec(i-1,j,k+1,board,word,visited,ans);
        rec(i,j-1,k+1,board,word,visited,ans);
        visited[i][j]=0;

    }
}
