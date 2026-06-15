class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
     List<List<Integer>> ans = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
        
        rec(0,nums,ans,temp,0,target);
        return ans;
        
    }
    public void rec(int ind,int[]nums,List<List<Integer>> ans,List<Integer>temp,int sum,int target){
        if(sum==target){
            List<Integer> temp1 = new ArrayList<>(temp);
            ans.add(temp1);
            return;
        }
        if(ind>=nums.length || sum>target){
            return;
        }
        
        
            temp.add(nums[ind]);
            sum+=nums[ind];
        rec(ind,nums,ans,temp,sum,target);
        temp.remove(temp.size()-1);
            sum-=nums[ind];
        rec(ind+1,nums,ans,temp,sum,target);
        

    }
}
