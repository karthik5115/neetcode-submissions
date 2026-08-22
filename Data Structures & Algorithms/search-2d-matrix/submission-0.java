class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=-1, m = matrix.length,n=matrix[0].length;
            int start=0;
            int end= (m*n)-1;
            while(start<=end){
                int mid = start + ((end-start)/2);
                int i= mid/n;
                int j= mid%n;
                if(matrix[i][j]>target){
                    end=mid-1;
                }
                else if(matrix[i][j]<target){
                    start=mid+1;
                }
                else{
                    return true;
                }
            }
        
return false;
    }
}