class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
       dfs(0,s,res,wordDict);
       return ans;
    }
    public void dfs(int i,String s,List<String> res,List<String> wordDict){
        if(i==s.length()){
           String xx ="";
           for(String w:res){
            xx += w+" ";
           }
            ans.add(xx.substring(0,xx.length()-1));
            return;
        }
        if(i>s.length()){
            return;
        }
        for(String word:wordDict){
            if(match(word,s.substring(i,s.length()))){
                res.add(word);
                dfs(i+word.length(),s,res,wordDict);
                res.remove(res.size()-1);
            }
        }
    }
    boolean match(String s, String y){
        if(y.length()>=s.length()){
            for(int i=0;i<s.length();i++){
                if(y.charAt(i)!=s.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}