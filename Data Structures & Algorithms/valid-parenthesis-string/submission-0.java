class Solution {
    public boolean checkValidString(String s) {
        int leftmin=0;
        int leftmax=0;
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x=='('){
                leftmin++;
                leftmax++;
            }
            else if(x==')'){
                leftmin--;
                leftmax--;
            }
            else{
                leftmin--;
                leftmax++;
            }
            if(leftmax<0){
                return false;
            }
            if(leftmin<0){
                leftmin=0;
            }
        }
        return leftmin==0;
    }
}
