class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min=0,gmin=nums[0],max=0,gmax=nums[0],sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max+=nums[i];
            min+=nums[i];
            gmax= Math.max(gmax,max);
            if(max<0){
                max=0;
            }
            if(min>nums[i]){
                min=nums[i];
            }
            gmin=Math.min(gmin,min);
        }
        if(gmax<0){
            return gmax;
        }
      return  Math.max(gmax,sum-gmin);
        
    }
}