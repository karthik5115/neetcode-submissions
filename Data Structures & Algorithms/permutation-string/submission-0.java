class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] s1freq= new int[26];
        int [] s2freq=new int[26];
        for(int i=0;i<s1.length();i++){
            s1freq[s1.charAt(i)-'a']++;
            s2freq[s2.charAt(i)-'a']++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(s1freq[i]==s2freq[i]){
                matches++;
            }
        }
        int l=0;
        for(int i=s1.length();i<s2.length();i++){
            if(matches==26){
                return true;
            }
            char c = s2.charAt(i);
            s2freq[c-'a']++;
            if(s1freq[c-'a']==s2freq[c-'a']){
                matches++;
            }
            else if(s1freq[c-'a']==s2freq[c-'a']-1){
                matches--;
            }
            c = s2.charAt(l);
            l++;
            s2freq[c-'a']--;
            if(s1freq[c-'a']==s2freq[c-'a']){
                matches++;
            }
            else if(s1freq[c-'a']==s2freq[c-'a']+1){
                matches--;
            }
        }
        return matches==26;
    }
}
