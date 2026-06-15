class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        rec(0,nums,ans,temp);
        return ans;
        
    }
    public void rec(int ind,int[]nums,List<List<Integer>> ans,List<Integer>temp){
        System.out.println(ind +" h"+temp);
        // if(ind==nums.length){
            List<Integer> temp1 = new ArrayList<>(temp);
            ans.add(temp1);
        //     return;
        // }
        for(int i=ind;i<nums.length;i++){
            
            if(i>ind && nums[i]==nums[i-1]){
                continue;
            }
        temp.add(nums[i]);
        rec(i+1,nums,ans,temp);
        temp.remove(temp.size()-1);
          
        }
        

    }
}
