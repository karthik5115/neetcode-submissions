class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int m1=1,m2=1;
        int l1=1,l2=1;
        for(int i=0;i<arr.length-1;i++){
            if(i%2==0){
                if(arr[i]<arr[i+1]){
                    l2=1;
                    l1++;
                }
                else if(arr[i]>arr[i+1]){
                    l2++;
                    l1=1;
                }
                else{
                    l1=1;
                    l2=1;
                }

            }
            else{
                if(arr[i]>arr[i+1]){
                    l2=1;
                    l1++;
                }
                 else if(arr[i]<arr[i+1]){
                    l1=1;
                    l2++;
                }
                else{
                    l1=1;
                    l2=1;
                }

            }
            m1=Math.max(l1,m1);
            m2=Math.max(l2,m2);

        }
        return Math.max(m1,m2);
        
    }
}