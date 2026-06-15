class Solution {
    public int numDecodings(String s) {
         if(s.equals("")){
            return 1;
        }
        if(s.charAt(0)=='0'){
            return 0;
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
        return ans;
    }
}
