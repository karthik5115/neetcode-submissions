class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int numDecodings(String s) {
         if(s.equals("")){
            return 1;
        }
        if(s.charAt(0)=='0'){
            return 0;
        }
       if(map.containsKey(s)){
        return map.get(s);
       }
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(Integer.parseInt(s.substring(0,i+1))<=26){
                ans+=numDecodings(s.substring(i+1,s.length()));
            }
            else{
                break;
            }
        }
        map.put(s,ans);
        return ans;
    }
}
