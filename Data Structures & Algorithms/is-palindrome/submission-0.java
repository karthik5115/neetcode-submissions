class Solution {
    public boolean isPalindrome(String s) {
        int st=0,e=s.length()-1;
        while(st<=e){
            if(!((s.charAt(st)>='A' && s.charAt(st)<='z') || (s.charAt(st)>='0' && s.charAt(st)<='9'))){
                st++;
                continue;
            }
            if(!((s.charAt(e)>='A' && s.charAt(e)<='z') || (s.charAt(e)>='0' && s.charAt(e)<='9'))){
                e--;
                continue;
            }
           String x = (""+s.charAt(st)).toLowerCase();
           String y = (""+s.charAt(e)).toLowerCase();
           System.out.println(x+" "+y);
           if(!x.equals(y)){
            return false;
           }
            st++;
            e--;
        }
        return true;
    }
}
