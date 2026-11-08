class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0, end=0,n=nums.length-1;
        while(end<=n){
            nums[start]=nums[end];
            while(end<=n && nums[start]==nums[end]){
                end++;
            }
            start++;
        }
        return start;


        
    }
}