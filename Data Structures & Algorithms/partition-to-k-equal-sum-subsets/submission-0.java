class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
         int totalLength = Arrays.stream(nums).sum();
        if (totalLength % k != 0) return false;
        int length = totalLength / k;
        int[] parts = new int[k];
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, parts, 0, length);
    }
    public boolean dfs(int[]nums,int[]parts,int i,int length){
        if(i==nums.length){
            return true;
        }
        for(int j=0;j<parts.length;j++){
            if(parts[j]+nums[i]<=length){
                parts[j]+=nums[i];
                if(dfs(nums,parts,i+1,length)){
                    return true;
                }
                parts[j]-=nums[i];
            }
            if(parts[j]==0){
                break;
            }

        }
        return false;
    }
        private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}