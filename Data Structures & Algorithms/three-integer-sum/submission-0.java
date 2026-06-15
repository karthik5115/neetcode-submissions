class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
             if(i>0 && nums[i-1]==nums[i]){
                        continue;
                    }
            int x = nums[i];
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int total = x+nums[l]+nums[r];
                if(total<0){
                    l++;
                }
                else if(total>0){
                    r--;
                }
                else{
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[l]);
                    ans.add(nums[r]);
                    res.add(ans);
                    l++;
                    r--;
                    while(l<r && nums[l-1]==nums[l]){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
