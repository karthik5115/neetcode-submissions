class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0,num = nums[0];
        for(int i:nums){
            if(i==num){
                cnt++;
            }
            else{
                cnt--;
            }
            if(cnt<0){
                cnt=1;
                num=i;
            }
        }
        return num;
        
    }
}