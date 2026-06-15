class Solution {
    public String longestPalindrome(String s) {
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
        int max_len=0,ind=-1;
        for(int i=0;i<p.length;i++){
            if(p[i]>max_len){
                max_len=p[i];
                ind = i;
            }
        }
        String x = t.charAt(ind)=='#'?"":t.charAt(ind)+"";
        for(int i=1;i<=max_len;i++){
            if(t.charAt(ind+i)=='#'){
                continue;
            }
            x = t.charAt(ind+i)+x+t.charAt(ind+i);
        }
        return x;

    }
}
