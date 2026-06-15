class Solution {
    public int maxProduct(int[] nums) {
        int max_p=1;
        int min_p=1;
        int res=nums[0];
        for(int i:nums){
            int temp = max_p;
            max_p=Math.max(i,Math.max(i*max_p,i*min_p));
            min_p=Math.min(i,Math.min(i*temp,i*min_p));
            res=Math.max(max_p,res);
        }
        return res;
    }

}
