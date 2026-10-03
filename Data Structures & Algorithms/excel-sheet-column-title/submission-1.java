class Solution {
    public String convertToTitle(int n) {
        if(n==0){
            return "";
        }
        n=n-1;
        return convertToTitle(n/26)+(char)('A'+n%26);
    }
}