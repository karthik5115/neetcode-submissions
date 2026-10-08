class NumMatrix {
    
    int [][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        this.sumMatrix = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            int sum=0;
            for(int j=0;j<matrix[0].length;j++){
                int above = sumMatrix[i][j+1];
                sum+=matrix[i][j];
                sumMatrix[i+1][j+1]=above+sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;col1++;row2++;col2++;
        int total = sumMatrix[row2][col2];
        int above = sumMatrix[row1-1][col2];
        int left = sumMatrix[row2][col1-1];
        int leftabove = sumMatrix[row1-1][col1-1];
        return total+leftabove-left-above;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */