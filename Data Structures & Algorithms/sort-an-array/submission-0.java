class Solution {
    public int[] sortArray(int[] nums) {
        int l = 0,r=nums.length-1;
        divide(l,r,nums);
        return nums;
    }
    public void divide(int l,int r,int[]nums){
        if(l<r){
            int mid = l + (r-l)/2;
            divide(l,mid,nums);
            divide(mid+1,r,nums);
            conq(l,mid,r,nums);
        }    
    }
    public void conq(int l,int mid,int r,int[]nums){
        int [] temp = new int[r-l+1];
        int l2 = mid+1,l1=l,r1=mid,r2=r,ind=0;
        while(l1<=r1 && l2<=r2){
            if(nums[l1]<nums[l2]){
                temp[ind++]=nums[l1++];
            }
            else{
                temp[ind++]=nums[l2++];
            }
        }
        while(l1<=r1){
             temp[ind++]=nums[l1++];
        }
        while(l2<=r2){
            temp[ind++]=nums[l2++];
        }
        for(int i:temp){
            nums[l++]=i;
        }
    }
}