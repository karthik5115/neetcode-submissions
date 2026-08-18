class Solution {
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        backtracking(nums.length,new ArrayList<>());
        return res;
    }

    void backtracking(int size,List<Integer> temp){
        if(size==0){
            List<Integer> temp1 = new ArrayList<>(temp);
            res.add(temp1);
            return;
        }
        List<Integer> ks = new ArrayList<>(map.keySet());

        for(Integer i:ks){
            size--;
            map.put(i,map.getOrDefault(i,0)-1);
            temp.add(i);
            if(map.get(i)<=0){
                map.remove(i);
            }
            backtracking(size,temp);
            map.put(i,map.getOrDefault(i,0)+1);
            temp.remove(temp.size() - 1);
            size++;
        }
        
    }
}