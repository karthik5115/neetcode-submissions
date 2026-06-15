class Solution {
    public int minDistance(String word1, String word2) {
        return rec(0,0,word1,word2);
    }
    public int rec(int i,int j,String word1, String word2){
        if(j==word2.length()){
             return (word1.length()-i);
        }
        if(i==word1.length()){
            return (word2.length()-j);
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return rec(i+1,j+1,word1,word2);
        }
        return 1+Math.min(Math.min(rec(i+1,j,word1,word2),rec(i,j+1,word1,word2)),rec(i+1,j+1,word1,word2));
    }
}
