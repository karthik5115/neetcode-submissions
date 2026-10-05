class Solution {
    public int removeElement(int[] nums, int val) {
        int left=0,right=nums.length;
        while(left<right){
            if(val==nums[left]){
                nums[left]=nums[--right];
                // right--;
            }
            else{
                left++;
            }
}
        return right;
        
    }
}