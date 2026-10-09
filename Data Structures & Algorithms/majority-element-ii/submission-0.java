class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int n1=-1,n2=-1,c1=0,c2=0;
        for(int i:nums){
            if(i==n1){
                c1++;
            }
            else if(i==n2){
                c2++;
            }
            else if(c1==0){
                c1=1;
                n1=i;
            }
            else if(c2==0){
                c2=1;
                n2=i;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;c2=0;
        List<Integer> x = new ArrayList<>();
        for(int i:nums){
            if(i==n1){
                c1++;
            }
            if(i==n2){
                c2++;
            }
        }
        if(c1>n/3) x.add(n1);
        if(c2>n/3) x.add(n2);
        return x;
    }
}