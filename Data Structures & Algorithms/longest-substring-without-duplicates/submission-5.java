class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int lf=0,max_length=0;
        for(int i=0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                if(mp.get(s.charAt(i))>=lf){
                    int length = i-lf;
                    max_length=Math.max(max_length,length);
                    lf=mp.get(s.charAt(i))+1;
                }
            }
            mp.put(s.charAt(i),i);
        }
        max_length = Math.max(max_length, s.length() - lf);
        return max_length;
        
    }
}