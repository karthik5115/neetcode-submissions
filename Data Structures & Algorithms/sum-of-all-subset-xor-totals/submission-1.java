class Solution {
    int[]sum=new int[1];
    public int subsetXORSum(int[] nums) {
        backtracking(0,0,nums);
        return sum[0];
    }
    public void backtracking(int i,int xsum,int[]nums){
        if(i==nums.length){
            sum[0] += xsum;
            return ;
        }
        backtracking(i+1,xsum^nums[i],nums);
        backtracking(i+1,xsum,nums);
    }
}