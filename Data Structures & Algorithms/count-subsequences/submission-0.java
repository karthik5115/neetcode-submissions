class Solution {
    public int numDistinct(String s, String t) {
       return rec(0,0,s,t);
    }
    public int rec(int i,int j,String s, String t){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
          ans+=  rec(i+1,j+1,s,t);
        }
       ans+= rec(i+1,j,s,t);
       return ans;
    }
}
