class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0,high=0,ans=0;
        for(int i:nums){
            low = Math.max(low,i);
            high+=i;
        }
        ans=high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(subarrays(nums,mid)<=k){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
        int subarrays(int []nums,int mid){
            int noOfarrs=0,sum=0;
            for(int i:nums){
                sum+=i;
                if(sum>mid){
                    noOfarrs++;
                    sum=i;
                }
            }
            if(sum>0){
                noOfarrs++;
            }
            return noOfarrs;

        }
    
}