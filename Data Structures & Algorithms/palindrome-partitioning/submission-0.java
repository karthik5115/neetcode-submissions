class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        rec(s,0);
        return ans;
    }
    public boolean isPalin(String s){
        int start=0,end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void rec(String s,int start){
        if(start==s.length()){
            ans.add(new ArrayList<>(res));
        }
        for(int i=start;i<s.length();i++){
            if(isPalin(s.substring(start,i+1))){
                res.add(s.substring(start,i+1));
                rec(s,i+1);
                res.remove(res.size()-1);
            }
        }
    }
}
