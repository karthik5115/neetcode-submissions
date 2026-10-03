class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length(),l2=str2.length();
        for(int i=Math.min(l1,l2);i>=1;i--){
            if(isGcd(i,l1,l2,str1,str2)){
                return str1.substring(0,i);
            }
        }
        return "";
    }
    public boolean isGcd(int i,int l1,int l2,String s1,String s2){
        if(l1%i!=0 || l2%i!=0){
            return false;
        }
        String sub = s1.substring(0,i);
        int f1 = l1/i, f2=l2/i;
        return s1.equals(sub.repeat(f1)) && s2.equals(sub.repeat(f2));
    }
}