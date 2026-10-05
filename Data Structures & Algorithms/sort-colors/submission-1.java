class Solution {
    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1;
        int i=left;
        while(left<=right && i<=right){
            if(nums[i]==0){
                swap(left,i,nums);
                left++;
            }
            else if(nums[i]==2){
                swap(right,i,nums);
                right--;
                i--;
            }
            i++;

        }
    }
            public void swap(int x,int y,int[]nums){
            int temp = nums[x];
            nums[x]=nums[y];
            nums[y]=temp;
        }
}