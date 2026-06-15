class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int cnt=0;
        rec(0,0,matrix,ans,1,cnt);
        return ans;
    }
    public void rec(int i,int j,int[][]matrix,List<Integer> ans,int direc,int cnt){
            
            int x=i,y=j;
            switch(direc){
                case 1:
                    y=j+1;
                    break;
                
                case 2:
                    x=i+1;
                    break;
                
                case 3:
                    y=j-1;
                    break;
                
                case 4:
                    x=i-1;
                    break;
                
            }
            
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]!=101){
                ans.add(matrix[i][j]);
                matrix[i][j]=101;
                rec(x,y,matrix,ans,direc,cnt+1);
            }
            else{
                if(cnt==matrix[0].length * matrix.length-1){
                    ans.add(matrix[i][j]);
                return;
            }
                rec(i,j,matrix,ans,(direc%4+1),cnt);
            }
    }
}
