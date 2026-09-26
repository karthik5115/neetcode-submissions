class Solution {
    public int countSubstrings(String s) {
         String t = "^";
        for(int i=0;i<s.length();i++){
            t+="#"+s.charAt(i);
        }
        t+="#"+"$";
        int [] p = new int[t.length()];
        int c=0,r=0;
        for(int i=1;i<t.length()-1;i++){
            p[i] = (i<r)?Math.min(p[2*c-i],r-i):0;
            while(t.charAt(i+p[i]+1)==(t.charAt(i-p[i]-1))){
               // System.out.println(i+" "+i+p[i]+1);
                p[i]++;
            }
            if(i+p[i]>r){
                c=i;
                r=i+p[i];
            }
        }
        int ans=0;
       for (int i = 1; i < p.length - 1; i++) {
    ans += (p[i] + 1) / 2;
}
        return ans;
    }
}
