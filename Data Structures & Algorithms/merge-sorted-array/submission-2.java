class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        int x = m-1,y=n-1;
        while(y>=0){
            if(x>=0 && nums1[x]>nums2[y]){
                nums1[last--]=nums1[x--];
            }
            else{
                nums1[last--]=nums2[y--];
            }
        }
    }
}