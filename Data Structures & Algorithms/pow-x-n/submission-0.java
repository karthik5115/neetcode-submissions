class Solution {
    public double mypow(double x,int n){
                if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n%2==0){
            double temp =  mypow(x,n/2);
            return temp*temp;
        }
        return x * mypow(x,n-1);
    }
    public double myPow(double x, int n) {
        double temp = mypow(x,Math.abs(n));
        if(n<0){
            return 1/temp;
        }
        return temp;
    }
}
