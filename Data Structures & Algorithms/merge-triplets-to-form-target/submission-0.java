class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for(int i=0;i<triplets.length;i++){
            for(int j=0;j<3;j++){
                if(triplets[i][j]>target[j]){
                    triplets[i][0]=0;
                    triplets[i][1]=0;
                    triplets[i][2]=0;
                    break;
                }
            }
        }
        int [] ans = new int [] {0,0,0};
         for(int i=0;i<triplets.length;i++){
            ans[0]= Math.max(triplets[i][0],ans[0]);
            ans[1]= Math.max(triplets[i][1],ans[1]);
            ans[2]= Math.max(triplets[i][2],ans[2]);
         }
         if(ans[0]== target[0] && ans[1]==target[1] && ans[2]==target[2]){
            return true;
         }
         return false;

    }
}
