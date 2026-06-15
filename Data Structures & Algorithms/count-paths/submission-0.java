class Solution {
    public int uniquePaths(int m, int n) {
       return  rec(0,0,m,n);
    }
    public int rec(int i,int j,int m,int n){
        if(i<0 || i>=m || j>=n || j<0){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        return rec(i+1,j,m,n)+rec(i,j+1,m,n);

    }
}
