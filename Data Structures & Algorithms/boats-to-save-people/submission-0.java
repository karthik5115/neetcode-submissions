class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l =0, r=people.length-1,res=0;
        Arrays.sort(people);
        while(l<=r){
            if(people[l]+people[r]>limit){
                r--;
            }
            else{
                l++;
                r--;
            }
            res++;
        }
        return res;
        
    }
}