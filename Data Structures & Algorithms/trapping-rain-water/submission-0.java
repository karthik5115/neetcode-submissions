class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,leftmax=0,rightmax=0,ans=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]<leftmax){
                    ans+=(leftmax-height[left]);
                }
                else{
                    leftmax=height[left];
                }
                left++;
            }
            else{
                if(height[right]<rightmax){
                    ans+=(rightmax-height[right]);
                }
                else{
                    rightmax=height[right];
                }
                right--;
            }
        }
        return ans;
        
    }
}
