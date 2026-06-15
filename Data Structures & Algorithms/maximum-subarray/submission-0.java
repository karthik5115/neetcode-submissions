class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,max_s=Integer.MIN_VALUE;
   for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        max_s = Math.max(max_s,sum);
        if(sum<0){
            sum=0;
        }
   }
   return max_s;     
    }
}
