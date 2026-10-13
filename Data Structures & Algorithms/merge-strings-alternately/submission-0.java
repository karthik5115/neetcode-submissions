class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s =new StringBuilder();
        int x =0, y=0;
        while(x<word1.length() && y<word2.length()){
            if(x==y){
                s.append(word1.charAt(x));
                x++;
            }
            else{
                s.append(word2.charAt(y));
                y++;
            }
        }
        while(x<word1.length()){
            s.append(word1.charAt(x));
                x++;
        }
        while( y<word2.length()){
            s.append(word2.charAt(y));
                y++;
        }
return s.toString();
    }
}