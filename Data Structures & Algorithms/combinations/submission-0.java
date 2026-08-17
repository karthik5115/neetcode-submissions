class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        recursion(comb,1,n,k,ans);
        return ans;
        
    }
    public void recursion(List<Integer> comb,int i,int n,int k,List<List<Integer>> ans){
        if(comb.size()==k){
            List<Integer> xx = new ArrayList<>(comb);
            ans.add(xx);
            return;
        }
        if(i<=n){
            comb.add(i);
            recursion(comb,i+1,n,k,ans);
            comb.remove(Integer.valueOf(i));
            recursion(comb,i+1,n,k,ans);
        }
        else{
            return;
        }
    }
}