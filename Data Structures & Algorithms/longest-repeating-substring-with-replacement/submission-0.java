class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int l=0,mfreq=0,ans=0;
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            mfreq=Math.max(mfreq,mp.get(s.charAt(i)));
            int window_length=(i-l+1);
            if(window_length-mfreq<=k){
                ans = Math.max(window_length,ans);
            }
            else{
                while(l<=i && i-l+1-mfreq>k){
                    mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)-1);
                    l++;
                }
            }
        }
        return ans;
    }
}
