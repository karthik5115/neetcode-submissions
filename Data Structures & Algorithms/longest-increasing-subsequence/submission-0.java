class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = Math.max(ans,rec(i,nums));
        }
       return ans;
    }
    public int rec(int i,int []nums){
        if(i==nums.length){
            return 0;
        }
        int ans = 1;
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]>nums[i]){
              ans =  Math.max(ans,1+rec(j,nums));
            }
        }
        return ans;
    }
}
