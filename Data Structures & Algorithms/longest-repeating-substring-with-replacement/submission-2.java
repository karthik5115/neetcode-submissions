class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int left=0,ans=0,max_fre=0;
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            max_fre = Math.max(max_fre,mp.get(s.charAt(i)));
            if((i-left+1)-max_fre<=k){
                ans = Math.max(ans,(i-left+1));
            }
            else{
                while(left<i && i-left+1-max_fre>k){
                    mp.put(s.charAt(left),mp.getOrDefault(s.charAt(left),0)-1);
                    left++;
                }
            }
        }
        return ans;
    }
}
