class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")|| num2.equals("0")){
            return "0";
        }
        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        n1.reverse();
        n2.reverse();
        System.out.println(n1.length());
        int []ans=new int[n1.length()+n2.length()+1];
        for(int i=0;i<n1.length();i++){
            for(int j=0;j<n2.length();j++){
                int digit=(n1.charAt(i)-'0')*(n2.charAt(j)-'0');
                System.out.println(digit);
                ans[i+j]+=digit;
                ans[i+j+1]+=ans[i+j]/10;
                ans[i+j]%=10;

            }
        }
        String res="";
         int i = ans.length - 1;
        while (i >= 0 && ans[i] == 0) {
            i--;
        }
        while (i >= 0) {
            res+=(ans[i--]);
        }
        return res;
    }
}
