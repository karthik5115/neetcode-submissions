class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high =0,sum=0,ans=Integer.MAX_VALUE;
        while(high<nums.length){
            sum+=nums[high];
                while(sum>=target){
                    ans = Math.min(ans,(high-low+1));
                    sum-=nums[low++];
                }
            high++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}